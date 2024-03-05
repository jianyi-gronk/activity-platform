package com.example.backend2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Label;
import com.example.backend2.mapper.LabelMapper;
import com.example.backend2.service.LabelService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import jakarta.annotation.Resource;

/**
 * (Label)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@Service("labelService")
public class LabelServiceImpl  extends ServiceImpl<LabelMapper, Label>  implements LabelService {
    @Resource
    private LabelMapper labelMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param activityId 主键
     * @return 实例对象
     */
    @Override
    public Label queryById(Integer activityId) {
        return this.labelMapper.queryById(activityId);
    }

    /**
     * 分页查询
     *
     * @param label       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Label> queryByPage(Label label, PageRequest pageRequest) {
        long total = this.labelMapper.count(label);
        return new PageImpl<>(this.labelMapper.queryAllByLimit(label, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param label 实例对象
     * @return 实例对象
     */
    @Override
    public Label insert(Label label) {
        this.labelMapper.insert(label);
        return label;
    }

    /**
     * 修改数据
     *
     * @param label 实例对象
     * @return 实例对象
     */
    @Override
    public Label update(Label label) {
        this.labelMapper.update(label);
        return this.queryById(label.getActivityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param activityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer activityId) {
        return this.labelMapper.deleteById(activityId) > 0;
    }
}
