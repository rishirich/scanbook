package com.scanbuy.scanbook.dao;

import com.scanbuy.scanbook.beans.Book;
import com.scanbuy.scanbook.beans.SelectQueryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDao implements DaoInterface<Book>{

    @Autowired
    private MySQLExecutor mySQLExecutor;

    @Override
    public List<Book> getAll() {
        String query = "SELECT * from SCANBOOK_FACT_TABLE";
        SelectQueryBean selectQueryBean = mySQLExecutor.executeSelectQuery(query);
        return BookDaoUtility.resultSetToBooks(selectQueryBean);
    }

    @Override
    public List<Book> get(String field, String value, boolean exactMatch) {
        StringBuilder queryBuilder = new StringBuilder().append("SELECT * from SCANBOOK_FACT_TABLE ").append("WHERE ");
        String operator = exactMatch ? "=" : "LIKE";
        String wildCard = exactMatch ? "" : "%";
        queryBuilder.append(field).append(" ").append(operator).append(" '").append(wildCard).append(value).append(wildCard).append("'");
        SelectQueryBean selectQueryBean = mySQLExecutor.executeSelectQuery(queryBuilder.toString());
        return BookDaoUtility.resultSetToBooks(selectQueryBean);
    }

    @Override
    public boolean add(Book book) {
        return false;
    }

    @Override
    public boolean delete(Book book) {
        return false;
    }

}
