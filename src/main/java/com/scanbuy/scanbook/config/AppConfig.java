package com.scanbuy.scanbook.config;

import com.scanbuy.scanbook.dao.BookDao;
import com.scanbuy.scanbook.dao.DaoInterface;
import com.scanbuy.scanbook.service.BookService;
import com.scanbuy.scanbook.service.ScanBookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BookService bookService() {
        return new ScanBookService();
    }

    @Bean
    public DaoInterface bookDao() {
        return new BookDao();
    }
}
