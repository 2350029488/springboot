package com.example.hello.auto;

import com.example.hello.bean.BookProperties;
import com.example.hello.service.BookService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BookProperties.class)
public class BookServiceAutoConfigruation {

    @Bean
    @ConditionalOnMissingBean(BookService.class)
    public BookService bookService(){
        return new BookService();
    }
}
