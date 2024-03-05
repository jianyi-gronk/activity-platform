package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.domain.entity.Activity;

/**
 * (Activity)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
public interface ActivityService extends IService<Activity> {
    /**
     * 分页查询
     *
     * @param activity 筛选条件
     * @param page     分页对象
     * @return 查询结果
     */
    Page<Activity> queryByPage(Activity activity, Page<Activity> page);
//    /**
//     * 分页查询
//     *
//     * @param activity    筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    Page<Activity> queryByPage(Activity activity, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    Activity insert(Activity activity);

    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    Activity update(Activity activity);
}
