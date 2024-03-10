package com.example.backend2.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Comment;
import com.example.backend2.mapper.CommentMapper;
import com.example.backend2.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    /**
     * 分页查询
     *
     * @param comment 筛选条件
     * @param page    分页对象
     * @return 查询结果
     */
    @Override
    public Page<Comment> queryByPage(Comment comment, Page<Comment> page) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<Comment>() //
                .eq(comment.getId() != null, Comment::getId, comment.getId()) //
                .eq(comment.getActivityId() != null, Comment::getActivityId, comment.getActivityId()) //
                .eq(comment.getUserId() != null, Comment::getUserId, comment.getUserId()) //
                .like(StrUtil.isNotBlank(comment.getContent()), Comment::getContent, comment.getContent());
        return page(page, wrapper);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        save(comment);
        return comment;
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        updateById(comment);
        return getById(comment.getId());
    }
}
