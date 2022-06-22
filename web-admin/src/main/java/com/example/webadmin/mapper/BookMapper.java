package com.example.webadmin.mapper;

import com.example.webadmin.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface BookMapper {

    Book getById(@Param("id") Integer id);
}
