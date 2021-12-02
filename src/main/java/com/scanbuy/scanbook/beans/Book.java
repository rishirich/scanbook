package com.scanbuy.scanbook.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    @JsonProperty
    private long barcode;

    @JsonProperty
    private long isbn;

    @JsonProperty
    private String title;

    @JsonProperty
    private String authors;

    @JsonProperty
    private int pages;

    @JsonProperty
    private boolean isRead = false;

    @JsonProperty
    private String comments;

    public Book(long barcode, long isbn, String title, String authors, int pages, boolean isRead, String comments) {
        this.barcode = barcode;
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.pages = pages;
        this.isRead = isRead;
        this.comments = comments;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
