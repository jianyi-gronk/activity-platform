package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.domain.entity.Manager;

/**
 * (Manager)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
public interface ManagerService extends IService<Manager> {
    /**
     * 分页查询
     *
     * @param manager 筛选条件
     * @param page    分页对象
     * @return 查询结果
     */
    Page<Manager> queryByPage(Manager manager, Page<Manager> page);

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Manager insert(Manager manager);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Manager update(Manager manager);
}