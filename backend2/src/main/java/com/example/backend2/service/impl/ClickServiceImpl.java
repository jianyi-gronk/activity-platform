package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Click;
import com.example.backend2.mapper.ClickMapper;
import com.example.backend2.service.ClickService;
import org.springframework.stereotype.Service;

/**
 * (Click)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@Service("clickService")
public class ClickServiceImpl extends ServiceImpl<ClickMapper, Click> implements ClickService {
    /**
     * 分页查询
     *
     * @param click 筛选条件
     * @param page  分页对象
     * @return 查询结果
     */
    @Override
    public Page<Click> queryByPage(Click click, Page<Click> page) {
        LambdaQueryWrapper<Click> wrapper = new LambdaQueryWrapper<Click>() //
                .eq(click.getActivityId() != null, Click::getActivityId, click.getActivityId()) //
                .eq(click.getUserId() != null, Click::getUserId, click.getUserId()) //
                .eq(click.getTime() != null, Click::getTime, click.getTime());
        return page(page, wrapper);
    }

    /**
     * 新增数据
     *
     * @param click 实例对象
     * @return 实例对象
     */
    @Override
    public Click insert(Click click) {
        save(click);
        return click;
    }

    /**
     * 修改数据
     *
     * @param click 实例对象
     * @return 实例对象
     */
    @Override
    public Click update(Click click) {
        updateById(click);
        return getById(click.getActivityId());
    }
}
