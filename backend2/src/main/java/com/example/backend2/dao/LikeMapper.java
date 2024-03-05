package com.example.backend2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend2.domain.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Like)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@Mapper
public interface LikeMapper extends BaseMapper<Like> {

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    Like queryById(Long activityId);

    /**
     * 查询指定行数据
     *
     * @param like     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Like> queryAllByLimit(Like like, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param like 查询条件
     * @return 总行数
     */
    long count(Like like);

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 影响行数
     */
    int insert(Like like);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Like> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Like> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Like> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Like> entities);

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 影响行数
     */
    int update(Like like);

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 影响行数
     */
    int deleteById(Long activityId);

}

