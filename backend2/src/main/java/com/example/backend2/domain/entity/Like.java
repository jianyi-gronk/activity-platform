package com.example.backend2.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Like)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@TableName(value = "`like`")
public class Like implements Serializable {
    private static final long serialVersionUID = -83198561618971121L;

    private Long activityId;

    private Long userId;
}

