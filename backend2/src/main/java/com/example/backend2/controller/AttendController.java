package com.example.backend2.controller;

import com.example.backend2.domain.entity.Attend;
import com.example.backend2.service.AttendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * (Attend)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
@RestController
@RequestMapping("attend")
public class AttendController {
    /**
     * 服务对象
     */
    @Resource
    private AttendService attendService;

    /**
     * 分页查询
     *
     * @param attend      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Attend>> queryByPage(Attend attend, PageRequest pageRequest) {
        return ResponseEntity.ok(this.attendService.queryByPage(attend, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Attend> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.attendService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param attend 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Attend> add(@RequestBody Attend attend) {
        return ResponseEntity.ok(this.attendService.insert(attend));
    }

    /**
     * 编辑数据
     *
     * @param attend 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Attend> edit(@RequestBody Attend attend) {
        return ResponseEntity.ok(this.attendService.update(attend));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.attendService.removeById(id));
    }

}

