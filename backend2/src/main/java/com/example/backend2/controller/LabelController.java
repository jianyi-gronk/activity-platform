package com.example.backend2.controller;

import com.example.backend2.domain.entity.Label;
import com.example.backend2.service.LabelService;
import jakarta.annotation.Resource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Label)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@RestController
@RequestMapping("/label")
public class LabelController {
    /**
     * 服务对象
     */
    @Resource
    private LabelService labelService;

    /**
     * 分页查询
     *
     * @param label    筛选条件
     * @param pageNo   页码
     * @param pageSize 页面尺寸
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Label>> queryByPage(Label label, Integer pageNo, Integer pageSize) {
        return ResponseEntity.ok(this.labelService.queryByPage(label, new Page<>(pageNo, pageSize)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Label> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.labelService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param label 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Label> add(@RequestBody Label label) {
        return ResponseEntity.ok(this.labelService.insert(label));
    }

    /**
     * 编辑数据
     *
     * @param label 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Label> edit(@RequestBody Label label) {
        return ResponseEntity.ok(this.labelService.update(label));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.labelService.removeById(id));
    }
}

