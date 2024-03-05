package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.domain.entity.Click;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Click)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
public interface ClickService extends IService<Click> {

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    Click queryById(Long activityId);

    /**
     * 分页查询
     *
     * @param click       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Click> queryByPage(Click click, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param click 实例对象
     * @return 实例对象
     */
    Click insert(Click click);

    /**
     * 修改数据
     *
     * @param click 实例对象
     * @return 实例对象
     */
    Click update(Click click);

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 是否成功
     */
    boolean deleteById(Long activityId);

}
