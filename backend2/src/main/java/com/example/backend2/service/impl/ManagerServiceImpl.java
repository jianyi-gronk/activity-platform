package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.dao.ManagerMapper;
import com.example.backend2.domain.entity.Manager;
import com.example.backend2.service.ManagerService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * (Manager)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
@Service("managerService")
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    @Override
    public Manager queryById(Long activityId) {
        return this.managerMapper.queryById(activityId);
    }

    /**
     * 分页查询
     *
     * @param manager     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Manager> queryByPage(Manager manager, PageRequest pageRequest) {
        long total = this.managerMapper.count(manager);
        return new PageImpl<>(this.managerMapper.queryAllByLimit(manager, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public Manager insert(Manager manager) {
        this.managerMapper.insert(manager);
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
        this.managerMapper.update(manager);
        return this.queryById(manager.getActivityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long activityId) {
        return this.managerMapper.deleteById(activityId) > 0;
    }
}
