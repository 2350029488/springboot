package com.example.webadmin.serveice;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.webadmin.mapper.UserspringbootMapper;
import com.example.webadmin.pojo.Userspringboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * mybatis-plus 的操作
 *
 * 继承ServiceImpl<M,k> M是mapper接口  k是javabean
 * 还要实现其接口
 *
 */
@Service
public class UserspringbootServeiceImpl extends ServiceImpl<UserspringbootMapper, Userspringboot> implements UserspringbootServeice {

}
