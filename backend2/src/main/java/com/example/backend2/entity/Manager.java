package com.example.backend2.entity;

import java.io.Serializable;

/**
 * (Manager)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
public class Manager implements Serializable {
    private static final long serialVersionUID = -31050548595741079L;

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

