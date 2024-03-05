package com.example.backend2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend2.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Score)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    Score queryById(Long activityId);

    /**
     * 查询指定行数据
     *
     * @param score    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Score> queryAllByLimit(Score score, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param score 查询条件
     * @return 总行数
     */
    long count(Score score);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int insert(Score score);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Score> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Score> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Score> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Score> entities);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 影响行数
     */
    int deleteById(Long activityId);

}

