package com.example.backend2.domain.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Activity)实体类
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getClicknum() {
        return clicknum;
    }

    public void setClicknum(Long clicknum) {
        this.clicknum = clicknum;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

}

