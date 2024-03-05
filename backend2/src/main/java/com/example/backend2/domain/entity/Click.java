package com.example.backend2.domain.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Click)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
public class Click implements Serializable {
    private static final long serialVersionUID = 108997210255530425L;

    private Long activityId;

    private Long userId;

    private Date time;


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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}

