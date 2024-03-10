package com.example.backend2.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 出席实体类
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(name = "出席", description = "出席表")
public class Attend implements Serializable {
    @Serial
    private static final long serialVersionUID = 625714903065270440L;
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
}

