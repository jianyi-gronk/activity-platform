package com.example.backend2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend2.domain.entity.Click;
import com.example.backend2.service.ClickService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Click)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@RestController
@RequestMapping("/click")
public class ClickController {
    /**
     * 服务对象
     */
    @Resource
    private ClickService clickService;

    /**
     * 分页查询
     *
     * @param click    筛选条件
     * @param pageNo   页码
     * @param pageSize 页面尺寸
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Click>> queryByPage(Click click, Integer pageNo, Integer pageSize) {
        return ResponseEntity.ok(this.clickService.queryByPage(click, new Page<>(pageNo, pageSize)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Click> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.clickService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param click 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Click> add(@RequestBody Click click) {
        return ResponseEntity.ok(this.clickService.insert(click));
    }

    /**
     * 编辑数据
     *
     * @param click 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Click> edit(@RequestBody Click click) {
        return ResponseEntity.ok(this.clickService.update(click));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(this.clickService.removeById(id));
    }
}

