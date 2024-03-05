package com.example.backend2.controller;

import com.example.backend2.domain.entity.Manager;
import com.example.backend2.service.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * (Manager)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@RestController
@RequestMapping("manager")
public class ManagerController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerService managerService;

    /**
     * 分页查询
     *
     * @param manager     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Manager>> queryByPage(Manager manager, PageRequest pageRequest) {
        return ResponseEntity.ok(this.managerService.queryByPage(manager, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Manager> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.managerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param manager 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Manager> add(@RequestBody Manager manager) {
        return ResponseEntity.ok(this.managerService.insert(manager));
    }

    /**
     * 编辑数据
     *
     * @param manager 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Manager> edit(@RequestBody Manager manager) {
        return ResponseEntity.ok(this.managerService.update(manager));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.managerService.removeById(id));
    }

}

