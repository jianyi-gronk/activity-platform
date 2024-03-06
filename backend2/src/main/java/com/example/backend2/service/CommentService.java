package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.domain.entity.Comment;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
public interface CommentService extends IService<Comment> {
    /**
     * 分页查询
     *
     * @param comment 筛选条件
     * @param page    分页对象
     * @return 查询结果
     */
    Page<Comment> queryByPage(Comment comment, Page<Comment> page);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);
}
