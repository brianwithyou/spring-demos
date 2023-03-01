package com.example.springjpa.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.example.springcommon.common.PageResult;
import com.example.springjpa.convert.UserConvert;
import com.example.springjpa.entity.User;
import com.example.springjpa.repository.UserRepository;
import com.example.springjpa.service.UserService;
import com.example.springjpa.vo.request.UserPageRequest;
import com.example.springjpa.vo.response.UserPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * @author : brian
 * @since 0.1
 */
@Service
@Validated
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public PageResult<UserPageResponse> list(@Valid UserPageRequest user) {

        Pageable pageable = PageRequest.of(user.getPageNum() - 1, user.getPageSize()
                , Sort.Direction.DESC, "createTime");
        Specification<User> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (!ObjectUtils.isEmpty(user.getName())) {
                // like
                Predicate userName = criteriaBuilder.like(root.get("name"), "%" + user.getName() + "%");
                list.add(userName);

            }
            // in
            List<String> names = user.getNames();
            if (!ObjectUtils.isEmpty(names)) {
                if (CollectionUtil.isNotEmpty(names)) {
                    // 定义查询的字段
                    Path<String> path = root.get("name");
                    CriteriaBuilder.In<String> in = criteriaBuilder.in(path);
                    for (String param : names) {
                        in.value(param);
                    }
                    list.add(in);
                }
            }
            // equal notEqual
            if (StrUtil.isNotBlank(user.getGender())) {
                list.add(criteriaBuilder.equal(root.get("gender"), user.getGender()));
            }

            // not in
            if (CollectionUtil.isNotEmpty(names)) {
                // 定义查询的字段
                Path<String> path = root.get("name");
                CriteriaBuilder.In<String> in = criteriaBuilder.in(path);
                for (String param : names) {
                    // 存入值
                    in.value(param);
                }
                list.add(in.not());
            }
            return criteriaBuilder.and(list.toArray(new Predicate[0]));
        };

        Page<User> pageData = userRepository.findAll(specification, pageable);
        PageResult<UserPageResponse> pageResult  = PageResult.empty((long)pageData.getSize());
        pageData.getContent().forEach(userItem -> {
            UserPageResponse userResp = UserConvert.INSTANCE.convert(userItem);
            pageResult.getList().add(userResp);
        });
        return pageResult;
    }

}
