package com.example.backend2.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.User;
import com.example.backend2.mapper.UserMapper;
import com.example.backend2.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:09
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param page 分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, Page<User> page) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>() //
                .eq(user.getId() != null, User::getId, user.getId()) //
                .eq(user.getTime() != null, User::getTime, user.getTime()) //
                .like(StrUtil.isNotBlank(user.getUsername()), User::getUsername, user.getUsername()) //
                .like(StrUtil.isNotBlank(user.getName()), User::getName, user.getName()) //
                .eq(StrUtil.isNotBlank(user.getSex()), User::getSex, user.getSex()) //
                .like(StrUtil.isNotBlank(user.getPhone()), User::getPhone, user.getPhone()) //
                .like(StrUtil.isNotBlank(user.getEmail()), User::getEmail, user.getEmail()) //
                .like(StrUtil.isNotBlank(user.getDescription()), User::getDescription, user.getDescription());
        return page(page, wrapper);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        save(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        updateById(user);
        return getById(user.getId());
    }
}
