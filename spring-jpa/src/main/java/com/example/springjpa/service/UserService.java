package com.example.springjpa.service;

import com.example.springcommon.common.PageResult;
import com.example.springjpa.vo.request.UserPageRequest;
import com.example.springjpa.vo.response.UserPageResponse;

/**
 * @author : brian
 * @since 0.1
 */
public interface UserService {
    /**
     * list user
     * @param user user
     * @return result
     */
    PageResult<UserPageResponse> list(UserPageRequest user);
}
