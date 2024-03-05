package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.entity.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Score)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
public interface ScoreService extends IService<Score> {

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    Score queryById(Long activityId);

    /**
     * 分页查询
     *
     * @param score       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Score> queryByPage(Score score, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 是否成功
     */
    boolean deleteById(Long activityId);

}
