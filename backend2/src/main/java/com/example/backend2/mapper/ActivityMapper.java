package com.example.backend2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend2.domain.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Activity)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-05 22:11:05
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

}

