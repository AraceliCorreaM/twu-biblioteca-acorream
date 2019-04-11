package com.twu.biblioteca;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getBookInfo() {
        return String.format(title);
    }
}

