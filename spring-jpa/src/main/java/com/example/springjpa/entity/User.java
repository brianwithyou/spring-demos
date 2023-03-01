package com.example.springjpa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "account_number", length = 48)
    private String accountNumber;

    @Column(name = "nickname", length = 64)
    private String nickname;

    @Column(name = "username", length = 64)
    private String username;

    @Column(name = "password", length = 128)
    private String password;

    @Column(name = "id_card_no", length = 24)
    private String idCardNo;

    @Column(name = "mobile", length = 32)
    private String mobile;

    @Column(name = "email", length = 128)
    private String email;

    @Column(name = "point")
    private Integer point;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sign", length = 128)
    private String sign;

    @Column(name = "gender", nullable = false)
    private Integer gender;

    @Column(name = "wechat", length = 128)
    private String wechat;

    @Column(name = "vip_level", nullable = false)
    private Integer vipLevel;

    @Column(name = "birthday")
    private Instant birthday;

    @Column(name = "avatar", length = 256)
    private String avatar;

    @Column(name = "area", length = 128)
    private String area;

    @Column(name = "area_code", length = 128)
    private String areaCode;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "deleted", nullable = false)
    private Integer deleted;

    @Lob
    @Column(name = "extend_info")
    private String extendInfo;

    @Column(name = "last_login")
    private Instant lastLogin;

    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    @Column(name = "update_time", nullable = false)
    private Instant updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {return false;}
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}