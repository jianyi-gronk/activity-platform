package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.domain.entity.Attend;

/**
 * (Attend)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:06
 */
public interface AttendService extends IService<Attend> {
    /**
     * 分页查询
     *
     * @param attend 筛选条件
     * @param page   分页对象
     * @return 查询结果
     */
    Page<Attend> queryByPage(Attend attend, Page<Attend> page);

    /**
     * 新增数据
     *
     * @param attend 实例对象
     * @return 实例对象
     */
    Attend insert(Attend attend);

    /**
     * 修改数据
     *
     * @param attend 实例对象
     * @return 实例对象
     */
    Attend update(Attend attend);
}
