package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.dao.ClickMapper;
import com.example.backend2.entity.Click;
import com.example.backend2.service.ClickService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * (Click)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@Service("clickService")
public class ClickServiceImpl extends ServiceImpl<ClickMapper, Click> implements ClickService {
    @Resource
    private ClickMapper clickMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    @Override
    public Click queryById(Long activityId) {
        return this.clickMapper.queryById(activityId);
    }

    /**
     * 分页查询
     *
     * @param click       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Click> queryByPage(Click click, PageRequest pageRequest) {
        long total = this.clickMapper.count(click);
        return new PageImpl<>(this.clickMapper.queryAllByLimit(click, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param click 实例对象
     * @return 实例对象
     */
    @Override
    public Click insert(Click click) {
        this.clickMapper.insert(click);
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
        this.clickMapper.update(click);
        return this.queryById(click.getActivityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long activityId) {
        return this.clickMapper.deleteById(activityId) > 0;
    }
}
