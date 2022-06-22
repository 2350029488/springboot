package com.example.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webadmin.pojo.Userspringboot;
import org.apache.ibatis.annotations.Mapper;

/**
 * mybatis-plus操作
 *
 * 继承BaseMapper<Userspringboot> 其里面已经有了crud基础的sql
 */
@Mapper
public interface UserspringbootMapper extends BaseMapper<Userspringboot> {

}
