package com.example.springjpa.repository;

import com.example.springjpa.entity.User;
import com.example.springjpa.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : brian
 * @since 0.1
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {


    @Query(nativeQuery = true, value = " select u.*, tuc.company from t_user u " +
            " left join t_user_company tuc on u.id = tuc.user_id where u.id = ?1")
    UserDetail getDetail(@Param("id")Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update t_user set nickname = ?1" +
            " where t_user.id = (?2) ")
    int updateSql(@Param("nickname") String nickname, @Param("id") Long id);

}
