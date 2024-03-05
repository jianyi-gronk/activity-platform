package com.example.backend2.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Label)实体类
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
public class Label implements Serializable {
    private static final long serialVersionUID = -82432930783708074L;

    private Integer activityId;

    private String label;
}

