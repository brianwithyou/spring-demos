package com.example.springjpa.controller;

import com.example.springcommon.common.PageResult;
import com.example.springcommon.common.Result;
import com.example.springjpa.entity.User;
import com.example.springjpa.service.UserService;
import com.example.springjpa.vo.request.UserPageRequest;
import com.example.springjpa.vo.response.UserPageResponse;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : brian
 * @since 0.1
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    public Result<PageResult<UserPageResponse>> list(UserPageRequest user) {

        return Result.success(userService.list(user));
    }

}
