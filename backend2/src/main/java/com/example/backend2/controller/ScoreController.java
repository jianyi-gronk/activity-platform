package com.example.backend2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend2.domain.entity.Score;
import com.example.backend2.service.ScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Score)表控制层
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Tag(name = "Score接口", description = "Score接口")
@RestController
@RequestMapping("/score")
public class ScoreController {
    /**
     * 服务对象
     */
    @Resource
    private ScoreService scoreService;

    /**
     * 分页查询
     *
     * @param score    筛选条件
     * @param pageNo   页码
     * @param pageSize 页面尺寸
     * @return 查询结果
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @Parameters({ //
            @Parameter(name = "score", description = "筛选条件", in = ParameterIn.QUERY), //
            @Parameter(name = "pageNo", description = "页码", required = true, in = ParameterIn.QUERY), //
            @Parameter(name = "pageSize", description = "页面尺寸", required = true, in = ParameterIn.QUERY) //
    })
    @GetMapping
    public ResponseEntity<Page<Score>> queryByPage(Score score, Integer pageNo, Integer pageSize) {
        return ResponseEntity.ok(this.scoreService.queryByPage(score, new Page<>(pageNo, pageSize)));
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
    public ResponseEntity<Score> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.scoreService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param score 实体
     * @return 新增结果
     */
    @Operation(summary = "新增数据", description = "新增数据")
    @PostMapping
    public ResponseEntity<Score> add(@RequestBody Score score) {
        return ResponseEntity.ok(this.scoreService.insert(score));
    }

    /**
     * 编辑数据
     *
     * @param score 实体
     * @return 编辑结果
     */
    @Operation(summary = "编辑数据", description = "编辑数据")
    @PutMapping
    public ResponseEntity<Score> edit(@RequestBody Score score) {
        return ResponseEntity.ok(this.scoreService.update(score));
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
        return ResponseEntity.ok(this.scoreService.removeById(id));
    }

}

