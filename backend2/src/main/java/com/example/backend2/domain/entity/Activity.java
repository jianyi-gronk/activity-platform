package com.example.backend2.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (Activity)实体类
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
public class Activity implements Serializable {
    private static final long serialVersionUID = -86392116839979539L;
    /**
     * 活动 id
     */
    private Long id;
    /**
     * 创建者 id
     */
    private Long userId;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动图片
     */
    private String picture;
    /**
     * 活动描述
     */
    private String description;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 举办地点
     */
    private String location;
    /**
     * 人数上限
     */
    @TableField(value = "`limit`")
    private Long limit;
    /**
     * 点击次数
     */
    private Long clicknum;
    /**
     * 当前报名人数
     */
    private Long number;
    /**
     * 当前喜欢人数
     */
    private Long likes;
}

