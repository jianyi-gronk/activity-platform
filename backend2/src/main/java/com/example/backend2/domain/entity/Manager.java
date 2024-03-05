package com.example.backend2.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Manager)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Manager implements Serializable {
    private static final long serialVersionUID = -31050548595741079L;

    private Long activityId;

    private Long userId;
}

