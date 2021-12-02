package com.scanbuy.scanbook.service;

import com.scanbuy.scanbook.beans.Book;
import com.scanbuy.scanbook.beans.Filter;
import com.scanbuy.scanbook.constants.FilterType;
import com.scanbuy.scanbook.dao.DaoInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScanBookService implements BookService{

    @Autowired
    private DaoInterface bookDao;

    @Override
    public List<Book> getBooks() {
        return bookDao.getAll();
    }

    @Override
    public List<Book> getBook(Filter barcodeFilter) {
        return bookDao.get(barcodeFilter.getField(),barcodeFilter.getValue(),barcodeFilter.getFilterType() == FilterType.EQUALS);
    }

    @Override
    public List<Book> addBook(Book book) {
        return null;
    }

    @Override
    public List<Book> deleteBook(Book book) {
        return null;
    }
}
