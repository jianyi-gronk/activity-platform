package com.example.backend2.controller;

import com.example.backend2.domain.entity.Manager;
import com.example.backend2.service.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Manager)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Tag(name = "Manager接口", description = "Manager接口")
@RestController
@RequestMapping("/manager")
public class ManagerController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerService managerService;

    /**
     * 分页查询
     *
     * @param manager  筛选条件
     * @param pageNo   页码
     * @param pageSize 页面尺寸
     * @return 查询结果
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @Parameters({ //
            @Parameter(name = "manager", description = "筛选条件", in = ParameterIn.QUERY), //
            @Parameter(name = "pageNo", description = "页码", required = true, in = ParameterIn.QUERY), //
            @Parameter(name = "pageSize", description = "页面尺寸", required = true, in = ParameterIn.QUERY) //
    })
    @GetMapping
    public ResponseEntity<Page<Manager>> queryByPage(Manager manager, Integer pageNo, Integer pageSize) {
        return ResponseEntity.ok(this.managerService.queryByPage(manager, new Page<>(pageNo, pageSize)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Operation(summary = "通过主键查询单条数据", description = "通过主键查询单条数据")
    @Parameters({@Parameter(name = "id", description = "主键", in = ParameterIn.PATH)})
    @GetMapping("/{id}")
    public ResponseEntity<Manager> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.managerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param manager 实体
     * @return 新增结果
     */
    @Operation(summary = "新增数据", description = "新增数据")
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
    @Operation(summary = "编辑数据", description = "编辑数据")
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
    @Operation(summary = "删除数据", description = "删除数据")
    @Parameters({@Parameter(name = "id", description = "主键", in = ParameterIn.PATH)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(this.managerService.removeById(id));
    }

}

