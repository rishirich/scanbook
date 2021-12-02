package com.scanbuy.scanbook.dao;

import com.scanbuy.scanbook.beans.Book;

import java.util.List;

public interface DaoInterface<T> {
    List<T> getAll();

    List<Book> get(String field, String value, boolean exactMatch);

    boolean add(T t);

    boolean delete(T t);
}
