package com.example.backend2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend2.domain.entity.Comment;
import com.example.backend2.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 分页查询
     *
     * @param comment  筛选条件
     * @param pageNo   页码
     * @param pageSize 页面尺寸
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Comment>> queryByPage(Comment comment, Integer pageNo, Integer pageSize) {
        return ResponseEntity.ok(this.commentService.queryByPage(comment, new Page<>(pageNo, pageSize)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Comment> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.commentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param comment 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Comment> add(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.commentService.insert(comment));
    }

    /**
     * 编辑数据
     *
     * @param comment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Comment> edit(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.commentService.update(comment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(this.commentService.removeById(id));
    }
}

