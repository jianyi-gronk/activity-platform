package com.example.backend2.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 评论实体类
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(name = "评论", description = "评论表")
public class Comment implements Serializable {
    @Serial
    private static final long serialVersionUID = -33866981742778796L;
    /**
     * 评论ID
     */
    @Schema(description = "评论ID")
    private Long id;
    /**
     * 活动ID
     */
    @Schema(description = "活动ID")
    private Long activityId;
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Long userId;
    /**
     * 评论内容
     */
    @Schema(description = "评论内容")
    private String content;
}

