package com.example.backend2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend2.domain.entity.Activity;
import com.example.backend2.service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Activity)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:04
 */
@Tag(name = "活动接口", description = "活动接口")
@RestController
@RequestMapping("/activity")
public class ActivityController {
    /**
     * 服务对象
     */
    @Resource
    private ActivityService activityService;

    /**
     * 分页查询
     *
     * @param activity 筛选条件
     * @param pageNo   页码
     * @param pageSize 页面尺寸
     * @return 查询结果
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping
    public ResponseEntity<Page<Activity>> queryByPage(Activity activity, Integer pageNo, Integer pageSize) {
        return ResponseEntity.ok(this.activityService.queryByPage(activity, new Page<>(pageNo, pageSize)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Operation(summary = "通过主键查询单条数据", description = "通过主键查询单条数据")
    @GetMapping("/{id}")
    public ResponseEntity<Activity> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.activityService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param activity 实体
     * @return 新增结果
     */
    @Operation(summary = "新增数据", description = "新增数据")
    @PostMapping
    public ResponseEntity<Activity> add(@RequestBody Activity activity) {
        return ResponseEntity.ok(this.activityService.insert(activity));
    }

    /**
     * 编辑数据
     *
     * @param activity 实体
     * @return 编辑结果
     */
    @Operation(summary = "编辑数据", description = "编辑数据")
    @PutMapping
    public ResponseEntity<Activity> edit(@RequestBody Activity activity) {
        return ResponseEntity.ok(this.activityService.update(activity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @Operation(summary = "删除数据", description = "删除数据")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(this.activityService.removeById(id));
    }
}

