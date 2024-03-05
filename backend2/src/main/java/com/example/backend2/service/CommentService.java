package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
public interface CommentService extends IService<Comment> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Comment queryById(Long id);

    /**
     * 分页查询
     *
     * @param comment     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Comment> queryByPage(Comment comment, PageRequest pageRequest);

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

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
