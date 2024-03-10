package com.example.backend2.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 点击量实体类
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(name = "点击量", description = "点击量表")
public class Click implements Serializable {
    @Serial
    private static final long serialVersionUID = 108997210255530425L;
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
     * 时间
     */
    @Schema(description = "时间")
    private Date time;
}

