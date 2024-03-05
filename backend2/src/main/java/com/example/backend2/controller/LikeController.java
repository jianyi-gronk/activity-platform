package com.example.backend2.controller;

import com.example.backend2.domain.entity.Like;
import com.example.backend2.service.LikeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * (Like)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@RestController
@RequestMapping("like")
public class LikeController {
    /**
     * 服务对象
     */
    @Resource
    private LikeService likeService;

    /**
     * 分页查询
     *
     * @param like        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Like>> queryByPage(Like like, PageRequest pageRequest) {
        return ResponseEntity.ok(this.likeService.queryByPage(like, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Like> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.likeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param like 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Like> add(@RequestBody Like like) {
        return ResponseEntity.ok(this.likeService.insert(like));
    }

    /**
     * 编辑数据
     *
     * @param like 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Like> edit(@RequestBody Like like) {
        return ResponseEntity.ok(this.likeService.update(like));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.likeService.removeById(id));
    }

}

