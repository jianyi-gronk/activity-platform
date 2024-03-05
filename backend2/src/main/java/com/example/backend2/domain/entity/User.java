package com.example.backend2.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:09
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class User implements Serializable {
    private static final long serialVersionUID = -31470374967169598L;
    /**
     * 用户 id
     */
    private Long id;
    /**
     * 最后编辑时间
     */
    private Date time;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 个人简介
     */
    private String description;
}

