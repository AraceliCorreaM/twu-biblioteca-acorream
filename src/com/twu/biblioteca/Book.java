package com.twu.biblioteca;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private String borrower;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrower = "";
    }

    public String getBookTitle(){
        return this.title;
    }

    public String getBorrower(){
        return this.borrower;
    }

    public String getBookInfo() {
        return String.format("%-30s | %-30s | %d", title, author, year);
    }

    public void setBorrower(String borrower){
        this.borrower = borrower;
    }
}