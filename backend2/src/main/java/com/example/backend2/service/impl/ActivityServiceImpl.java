package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.mapper.ActivityMapper;
import com.example.backend2.domain.entity.Activity;
import com.example.backend2.service.ActivityService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * (Activity)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
@Service("activityService")
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    @Resource
    private ActivityMapper activityMapper;

    /**
     * 分页查询
     *
     * @param activity    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Activity> queryByPage(Activity activity, PageRequest pageRequest) {
        long total = this.activityMapper.count(activity);
        return new PageImpl<>(this.activityMapper.queryAllByLimit(activity, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    @Override
    public Activity insert(Activity activity) {
        save(activity);
        return activity;
    }

    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    @Override
    public Activity update(Activity activity) {
        updateById(activity);
        return getById(activity.getId());
    }
}
