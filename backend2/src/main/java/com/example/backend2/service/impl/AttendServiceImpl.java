package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Attend;
import com.example.backend2.mapper.AttendMapper;
import com.example.backend2.service.AttendService;
import org.springframework.stereotype.Service;

/**
 * (Attend)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@Service("attendService")
public class AttendServiceImpl extends ServiceImpl<AttendMapper, Attend> implements AttendService {
    /**
     * 分页查询
     *
     * @param attend 筛选条件
     * @param page   分页对象
     * @return 查询结果
     */
    @Override
    public Page<Attend> queryByPage(Attend attend, Page<Attend> page) {
        LambdaQueryWrapper<Attend> wrapper = new LambdaQueryWrapper<Attend>() //
                .eq(attend.getActivityId() != null, Attend::getActivityId, attend.getActivityId()) //
                .eq(attend.getUserId() != null, Attend::getUserId, attend.getUserId());
        return page(page, wrapper);
    }

    /**
     * 新增数据
     *
     * @param attend 实例对象
     * @return 实例对象
     */
    @Override
    public Attend insert(Attend attend) {
        save(attend);
        return attend;
    }

    /**
     * 修改数据
     *
     * @param attend 实例对象
     * @return 实例对象
     */
    @Override
    public Attend update(Attend attend) {
        updateById(attend);
        return getById(attend.getActivityId());
    }
}
