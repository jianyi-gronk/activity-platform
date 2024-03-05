package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.dao.ScoreMapper;
import com.example.backend2.entity.Score;
import com.example.backend2.service.ScoreService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * (Score)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Service("scoreService")
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    @Override
    public Score queryById(Long activityId) {
        return this.scoreMapper.queryById(activityId);
    }

    /**
     * 分页查询
     *
     * @param score       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Score> queryByPage(Score score, PageRequest pageRequest) {
        long total = this.scoreMapper.count(score);
        return new PageImpl<>(this.scoreMapper.queryAllByLimit(score, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score insert(Score score) {
        this.scoreMapper.insert(score);
        return score;
    }

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score update(Score score) {
        this.scoreMapper.update(score);
        return this.queryById(score.getActivityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long activityId) {
        return this.scoreMapper.deleteById(activityId) > 0;
    }
}
