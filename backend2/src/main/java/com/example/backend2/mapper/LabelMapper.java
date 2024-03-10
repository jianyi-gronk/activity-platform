package com.example.backend2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend2.domain.entity.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Label)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@Mapper
public interface LabelMapper extends BaseMapper<Label> {

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    Label queryById(Integer activityId);

    /**
     * 查询指定行数据
     *
     * @param label    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Label> queryAllByLimit(Label label, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param label 查询条件
     * @return 总行数
     */
    long count(Label label);

    /**
     * 新增数据
     *
     * @param label 实例对象
     * @return 影响行数
     */
    int insert(Label label);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Label> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Label> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Label> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Label> entities);

    /**
     * 修改数据
     *
     * @param label 实例对象
     * @return 影响行数
     */
    int update(Label label);

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 影响行数
     */
    int deleteById(Integer activityId);

}

