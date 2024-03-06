package com.example.backend2.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend2.domain.entity.Label;
import com.example.backend2.mapper.LabelMapper;
import com.example.backend2.service.LabelService;
import org.springframework.stereotype.Service;

/**
 * (Label)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
@Service("labelService")
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements LabelService {
    /**
     * 分页查询
     *
     * @param label 筛选条件
     * @param page  分页对象
     * @return 查询结果
     */
    @Override
    public Page<Label> queryByPage(Label label, Page<Label> page) {
        LambdaQueryWrapper<Label> wrapper = new LambdaQueryWrapper<Label>() //
                .eq(label.getActivityId() != null, Label::getActivityId, label.getActivityId()) //
                .like(StrUtil.isNotBlank(label.getLabel()), Label::getLabel, label.getLabel());
        return page(page, wrapper);
    }

    /**
     * 新增数据
     *
     * @param label 实例对象
     * @return 实例对象
     */
    @Override
    public Label insert(Label label) {
        save(label);
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
        updateById(label);
        return getById(label.getActivityId());
    }
}
