package com.example.backend2.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Score)实体类
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
public class Score implements Serializable {
    private static final long serialVersionUID = 454319892805239010L;

    private Long activityId;

    private Long userId;

    private Integer score;
}

