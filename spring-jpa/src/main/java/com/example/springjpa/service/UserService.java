package com.example.springjpa.service;

import com.example.springcommon.common.PageResult;
import com.example.springjpa.entity.UserDetail;
import com.example.springjpa.vo.request.UserPageRequest;
import com.example.springjpa.vo.response.UserPageResponse;

/**
 * @author : brian
 * @since 0.1
 */
public interface UserService {
    /**
     * list user by Specification
     * @param user user
     * @return result
     */
    PageResult<UserPageResponse> list(UserPageRequest user);

    /**
     * list by jpa example class
     * @return user list
     */
    PageResult<UserPageResponse> listByExample();

    /**
     * select with multi table
     * @return user list
     */
    UserDetail getDetail(Long id);

    int updateSql(String nickname, Long id);
}
