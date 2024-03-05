package com.example.backend2.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (Click)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Click implements Serializable {
    private static final long serialVersionUID = 108997210255530425L;

    private Long activityId;

    private Long userId;

    private Date time;
}

