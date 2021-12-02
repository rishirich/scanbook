package com.scanbuy.scanbook.service;

import com.scanbuy.scanbook.beans.Book;
import com.scanbuy.scanbook.beans.Filter;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    List<Book> getBook(Filter barcodeFilter);

    List<Book> addBook(Book book);

    List<Book> deleteBook(Book book);
}
