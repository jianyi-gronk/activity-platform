package com.example.backend2.controller;

import com.example.backend2.domain.entity.Click;
import com.example.backend2.service.ClickService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * (Click)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@RestController
@RequestMapping("click")
public class ClickController {
    /**
     * 服务对象
     */
    @Resource
    private ClickService clickService;

    /**
     * 分页查询
     *
     * @param click       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Click>> queryByPage(Click click, PageRequest pageRequest) {
        return ResponseEntity.ok(this.clickService.queryByPage(click, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Click> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.clickService.queryById(id));
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
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.clickService.deleteById(id));
    }

}

