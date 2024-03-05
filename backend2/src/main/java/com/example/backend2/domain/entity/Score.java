package com.example.backend2.domain.entity;

import java.io.Serializable;

/**
 * (Score)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
public class Score implements Serializable {
    private static final long serialVersionUID = 454319892805239010L;

    private Long activityId;

    private Long userId;

    private Integer score;


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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}

