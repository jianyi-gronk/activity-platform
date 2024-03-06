package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.domain.entity.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:09
 */
public interface UserService extends IService<User> {
    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param page 分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, Page<User> page);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);
}
