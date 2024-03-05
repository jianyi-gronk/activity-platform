package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.mapper.AttendMapper;
import com.example.backend2.domain.entity.Attend;
import com.example.backend2.service.AttendService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * (Attend)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
@Service("attendService")
public class AttendServiceImpl extends ServiceImpl<AttendMapper, Attend> implements AttendService {
    @Resource
    private AttendMapper attendMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    @Override
    public Attend queryById(Long activityId) {
        return this.attendMapper.queryById(activityId);
    }

    /**
     * 分页查询
     *
     * @param attend      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Attend> queryByPage(Attend attend, PageRequest pageRequest) {
        long total = this.attendMapper.count(attend);
        return new PageImpl<>(this.attendMapper.queryAllByLimit(attend, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param attend 实例对象
     * @return 实例对象
     */
    @Override
    public Attend insert(Attend attend) {
        this.attendMapper.insert(attend);
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
        this.attendMapper.update(attend);
        return this.queryById(attend.getActivityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long activityId) {
        return this.attendMapper.deleteById(activityId) > 0;
    }
}
