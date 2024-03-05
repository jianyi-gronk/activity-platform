package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.domain.entity.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Label)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:07
 */
public interface LabelService extends IService<Label> {
    /**
     * 分页查询
     *
     * @param label       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Label> queryByPage(Label label, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param label 实例对象
     * @return 实例对象
     */
    Label insert(Label label);

    /**
     * 修改数据
     *
     * @param label 实例对象
     * @return 实例对象
     */
    Label update(Label label);
}
