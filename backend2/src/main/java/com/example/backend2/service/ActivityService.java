package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.entity.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Activity)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
public interface ActivityService extends IService<Activity> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Activity queryById(Long id);

    /**
     * 分页查询
     *
     * @param activity    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Activity> queryByPage(Activity activity, PageRequest pageRequest);

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

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
