package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Score;
import com.example.backend2.mapper.ScoreMapper;
import com.example.backend2.service.ScoreService;
import org.springframework.stereotype.Service;

/**
 * (Score)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Service("scoreService")
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {
    /**
     * 分页查询
     *
     * @param score 筛选条件
     * @param page  分页对象
     * @return 查询结果
     */
    @Override
    public Page<Score> queryByPage(Score score, Page<Score> page) {
        LambdaQueryWrapper<Score> wrapper = new LambdaQueryWrapper<Score>() //
                .eq(score.getActivityId() != null, Score::getActivityId, score.getActivityId()) //
                .eq(score.getUserId() != null, Score::getUserId, score.getUserId()) //
                .eq(score.getScore() != null, Score::getScore, score.getScore());
        return page(page, wrapper);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score insert(Score score) {
        save(score);
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
        updateById(score);
        return getById(score.getActivityId());
    }
}
