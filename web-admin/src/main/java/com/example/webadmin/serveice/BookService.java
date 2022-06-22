package com.example.webadmin.serveice;


import com.example.webadmin.pojo.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    Book getById( Integer id);
}
