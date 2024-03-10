package com.example.backend2.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Activity;
import com.example.backend2.mapper.ActivityMapper;
import com.example.backend2.service.ActivityService;
import org.springframework.stereotype.Service;

/**
 * (Activity)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
@Service("activityService")
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    /**
     * 分页查询
     *
     * @param activity 筛选条件
     * @param page     分页对象
     * @return 查询结果
     */
    @Override
    public Page<Activity> queryByPage(Activity activity, Page<Activity> page) {
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper<Activity>() //
                .eq(activity.getId() != null, Activity::getId, activity.getId()) //
                .eq(activity.getUserId() != null, Activity::getUserId, activity.getUserId()) //
                .like(StrUtil.isNotBlank(activity.getTitle()), Activity::getTitle, activity.getTitle()) //
                .like(StrUtil.isNotBlank(activity.getDescription()), Activity::getDescription, activity.getDescription()) //
                .ge(activity.getStartTime() != null, Activity::getStartTime, activity.getStartTime()) //
                .le(activity.getEndTime() != null, Activity::getEndTime, activity.getEndTime()) //
                .like(StrUtil.isNotBlank(activity.getLocation()), Activity::getLocation, activity.getLocation());
        return page(page, wrapper);
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
