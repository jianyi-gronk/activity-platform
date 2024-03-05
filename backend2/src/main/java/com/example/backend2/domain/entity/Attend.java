package com.example.backend2.domain.entity;

import java.io.Serializable;

/**
 * (Attend)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
public class Attend implements Serializable {
    private static final long serialVersionUID = 625714903065270440L;

    private Long activityId;

    private Long userId;


    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}

