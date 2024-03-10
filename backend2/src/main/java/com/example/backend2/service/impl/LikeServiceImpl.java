package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Like;
import com.example.backend2.mapper.LikeMapper;
import com.example.backend2.service.LikeService;
import org.springframework.stereotype.Service;

/**
 * (Like)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Service("likeService")
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {
    /**
     * 分页查询
     *
     * @param like 筛选条件
     * @param page 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Like> queryByPage(Like like, Page<Like> page) {
        LambdaQueryWrapper<Like> wrapper = new LambdaQueryWrapper<Like>() //
                .eq(like.getActivityId() != null, Like::getActivityId, like.getActivityId()) //
                .eq(like.getUserId() != null, Like::getUserId, like.getUserId());
        return page(page, wrapper);
    }

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    @Override
    public Like insert(Like like) {
        save(like);
        return like;
    }

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    @Override
    public Like update(Like like) {
        updateById(like);
        return getById(like.getActivityId());
    }
}
