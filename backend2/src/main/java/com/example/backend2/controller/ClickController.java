package com.example.backend2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend2.domain.entity.Click;
import com.example.backend2.service.ClickService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Click)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@Tag(name = "Click接口", description = "Click接口")
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
    @Operation(summary = "分页查询", description = "分页查询")
    @Parameters({ //
            @Parameter(name = "click", description = "筛选条件", in = ParameterIn.QUERY), //
            @Parameter(name = "pageNo", description = "页码", required = true, in = ParameterIn.QUERY), //
            @Parameter(name = "pageSize", description = "页面尺寸", required = true, in = ParameterIn.QUERY) //
    })
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
    @Operation(summary = "通过主键查询单条数据", description = "通过主键查询单条数据")
    @Parameters({@Parameter(name = "id", description = "主键", in = ParameterIn.PATH)})
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
    @Operation(summary = "新增数据", description = "新增数据")
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
    @Operation(summary = "编辑数据", description = "编辑数据")
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
    @Operation(summary = "删除数据", description = "删除数据")
    @Parameters({@Parameter(name = "id", description = "主键", in = ParameterIn.PATH)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(this.clickService.removeById(id));
    }
}

