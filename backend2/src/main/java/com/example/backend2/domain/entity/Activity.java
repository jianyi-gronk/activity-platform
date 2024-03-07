package com.example.backend2.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动实体类
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(name = "活动", description = "活动表")
public class Activity implements Serializable {
    @Serial
    private static final long serialVersionUID = -86392116839979539L;
    /**
     * 活动ID
     */
    @Schema(description = "活动ID")
    private Long id;
    /**
     * 创建者ID
     */
    @Schema(description = "创建者ID")
    private Long userId;
    /**
     * 活动标题
     */
    @Schema(description = "活动标题")
    private String title;
    /**
     * 活动图片
     */
    @Schema(description = "活动图片")
    private String picture;
    /**
     * 活动描述
     */
    @Schema(description = "活动描述")
    private String description;
    /**
     * 开始时间
     */
    @Schema(description = "开始时间")
    private Date startTime;
    /**
     * 结束时间
     */
    @Schema(description = "结束时间")
    private Date endTime;
    /**
     * 举办地点
     */
    @Schema(description = "举办地点")
    private String location;
    /**
     * 人数上限
     */
    @Schema(description = "人数上限")
    @TableField(value = "`limit`")
    private Long limit;
    /**
     * 点击次数
     */
    @Schema(description = "点击次数")
    private Long clicknum;
    /**
     * 当前报名人数
     */
    @Schema(description = "当前报名人数")
    private Long number;
    /**
     * 当前喜欢人数
     */
    @Schema(description = "当前喜欢人数")
    private Long likes;
}

