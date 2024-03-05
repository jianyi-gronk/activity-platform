package com.example.backend2.entity;

import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = -33866981742778796L;

    private Long id;

    private Long activityId;

    private Long userId;
    /**
     * 评论内容
     */
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

