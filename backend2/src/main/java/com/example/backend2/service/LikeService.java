package com.example.backend2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend2.domain.entity.Like;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Like)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 22:11:08
 */
public interface LikeService extends IService<Like> {
    /**
     * 分页查询
     *
     * @param like        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Like> queryByPage(Like like, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    Like insert(Like like);

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    Like update(Like like);
}
