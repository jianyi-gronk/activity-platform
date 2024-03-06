package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Manager;
import com.example.backend2.mapper.ManagerMapper;
import com.example.backend2.service.ManagerService;
import org.springframework.stereotype.Service;

/**
 * (Manager)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Service("managerService")
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
    /**
     * 分页查询
     *
     * @param manager 筛选条件
     * @param page    分页对象
     * @return 查询结果
     */
    @Override
    public Page<Manager> queryByPage(Manager manager, Page<Manager> page) {
        LambdaQueryWrapper<Manager> wrapper = new LambdaQueryWrapper<Manager>() //
                .eq(manager.getActivityId() != null, Manager::getActivityId, manager.getActivityId()) //
                .eq(manager.getUserId() != null, Manager::getUserId, manager.getUserId());
        return page(page, wrapper);
    }

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public Manager insert(Manager manager) {
        save(manager);
        return manager;
    }

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public Manager update(Manager manager) {
        updateById(manager);
        return getById(manager.getActivityId());
    }
}
