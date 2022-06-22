package com.example.webadmin.mapper;

import com.example.webadmin.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybatis纯注解版与配置版的差别就是对于简单的sql可以直接在mapper的方法上
 * 写对于的查询 ，对于复杂的sql还是要写mapper.xml文件
 *
 * 混合版就是一个对pojo的操作既有注解mapper又有mapper.xml文件
 */


@Mapper
public interface DeptMapper {
    @Select("select*from dept where dept_id=#{id}")
//    @Options(useGeneratedKeys = true,keyProperty = "id")//争对自增id的返回
    Dept selectById(@Param("id")Integer id);


    List<Dept> selectAll();
}
