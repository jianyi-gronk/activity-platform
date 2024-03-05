package com.example.backend2.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Attend)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Attend implements Serializable {
    private static final long serialVersionUID = 625714903065270440L;

    private Long activityId;

    private Long userId;
}

