package com.example.springjpa.repository;

import com.example.springjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author : brian
 * @since 0.1
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {


}
