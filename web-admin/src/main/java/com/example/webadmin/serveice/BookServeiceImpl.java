package com.example.webadmin.serveice;

import com.example.webadmin.mapper.BookMapper;
import com.example.webadmin.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServeiceImpl implements BookService{
    @Autowired
    BookMapper bookMapper;
    @Override
    public Book getById(Integer id) {
        return bookMapper.getById(id);
    }
}
