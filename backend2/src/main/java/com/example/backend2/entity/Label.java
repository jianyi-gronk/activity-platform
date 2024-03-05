package com.example.backend2.entity;

import java.io.Serializable;

/**
 * (Label)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
public class Label implements Serializable {
    private static final long serialVersionUID = -82432930783708074L;

    private Integer activityId;

    private String label;


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}

