package com.example.webadmin.serveice;

import com.example.webadmin.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptServeice {
    Dept selectById(Integer id);
    List<Dept> selectAll();
}

