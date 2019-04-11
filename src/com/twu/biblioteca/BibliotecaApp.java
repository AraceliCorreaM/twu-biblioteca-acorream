package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {
    private ArrayList<Book> bookList;
    //private final PrintStream out;
    //private BufferedReader in;

    public BibliotecaApp(ArrayList<Book> listOfBooks){//, BufferedReader in, PrintStream out) {
        this.bookList = listOfBooks;
        //this.out = out;
        //this.in = in;
    }

    public void start() {
        this.getWelcomeMessage();
        if(bookList.isEmpty()){
            System.out.println("There is not Books Available.");
        } else {
            System.out.println("Books Available:");
            this.listBooks(bookList);
        }
    }

    public void getWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!.");
    }

    public void listBooks(ArrayList<Book> bookList) {
        String output = "";
        for (com.twu.biblioteca.Book book : bookList) {
            output += book.getBookInfo() + "\n";
        }
        System.out.print(output);
    }

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();

        bookList.add(new Book("Inferno", "Dan Brown", 2014));
        bookList.add(new Book("You'll Grow Out Of It", "Jessi Klein", 2016));
        bookList.add(new Book("You Are A Badass: How to Stop Doubting Your Greatness and Start Living an Awesome Life", "Jen Sincero", 2013));
        bookList.add(new Book("Learn Python 3 The Hard Way: A Very Simple", "Zed A. Shaw", 2017));

        BibliotecaApp biblioteca = new BibliotecaApp(bookList);

        biblioteca.start();
    }
}