package com.example.backend2.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(name = "用户", description = "用户表")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -31470374967169598L;
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Long id;
    /**
     * 最后编辑时间
     */
    @Schema(description = "最后编辑时间")
    private Date time;
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;
    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;
    /**
     * 头像
     */
    @Schema(description = "头像")
    private String avatar;
    /**
     * 姓名
     */
    @Schema(description = "姓名")
    private String name;
    /**
     * 性别
     */
    @Schema(description = "性别")
    private String sex;
    /**
     * 联系电话
     */
    @Schema(description = "联系电话")
    private String phone;
    /**
     * 联系邮箱
     */
    @Schema(description = "联系邮箱")
    private String email;
    /**
     * 个人简介
     */
    @Schema(description = "个人简介")
    private String description;
}

