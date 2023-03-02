package com.example.springjpa.entity;

/**
 * @author brian
 */
public interface UserDetail {

    Long getId();

    String getUsername();

    String getPassword();

    /**
     * 加入此参数在 t_user_company表
     * @return company
     */
    String getCompany();


}
