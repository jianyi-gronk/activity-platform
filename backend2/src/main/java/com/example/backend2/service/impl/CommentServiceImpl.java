package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Comment;
import com.example.backend2.mapper.CommentMapper;
import com.example.backend2.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import jakarta.annotation.Resource;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Long id) {
        return this.commentMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param comment     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Comment> queryByPage(Comment comment, PageRequest pageRequest) {
        long total = this.commentMapper.count(comment);
        return new PageImpl<>(this.commentMapper.queryAllByLimit(comment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        this.commentMapper.insert(comment);
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
        this.commentMapper.update(comment);
        return this.queryById(comment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.commentMapper.deleteById(id) > 0;
    }
}
