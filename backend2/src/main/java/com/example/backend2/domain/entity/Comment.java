package com.example.backend2.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Comment)实体类
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
public class Comment implements Serializable {
    private static final long serialVersionUID = -33866981742778796L;

    private Long id;

    private Long activityId;

    private Long userId;
    /**
     * 评论内容
     */
    private String content;
}

