package com.example.webadmin.serveice;

import com.example.webadmin.mapper.DeptMapper;
import com.example.webadmin.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServeiceImpl implements DeptServeice{
    @Autowired
    DeptMapper deptMapper;
    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }
}
