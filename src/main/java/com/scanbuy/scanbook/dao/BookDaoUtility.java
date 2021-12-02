package com.scanbuy.scanbook.dao;

import com.scanbuy.scanbook.beans.Book;
import com.scanbuy.scanbook.beans.SelectQueryBean;

import java.util.ArrayList;
import java.util.List;

class BookDaoUtility {
    static List<Book> resultSetToBooks(SelectQueryBean selectQueryBean) {
        List<String> columnNames = selectQueryBean.getColumnNames();
        List<Object> rsRows = selectQueryBean.getRsObjList();
        List<Book> bookList = new ArrayList<>();

        int barcodeIndex = columnNames.indexOf("Barcode");
        int isbnIndex =columnNames.indexOf("ISBN");
        int titleIndex = columnNames.indexOf("Title");
        int authorsIndex = columnNames.indexOf("Authors");
        int pagesIndex = columnNames.indexOf("Pages");
        int isReadIndex = columnNames.indexOf("Read");
        int notesIndex = columnNames.indexOf("Notes");

        rsRows.stream().forEach(row -> {
            Object[] rowArray = (Object[])row;
            Book book = new Book(
                    (Integer) rowArray[barcodeIndex]
                    , (Integer) rowArray[isbnIndex]
                    , (String) rowArray[titleIndex]
                    , (String) rowArray[authorsIndex]
                    , (Integer) rowArray[pagesIndex]
                    , (Boolean) rowArray[isReadIndex]
                    , (String) rowArray[notesIndex]
            );
            bookList.add(book);
        });
        return bookList;
    }
}
