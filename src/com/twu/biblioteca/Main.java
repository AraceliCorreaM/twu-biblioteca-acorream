package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();
        ArrayList<Movie> movieList  = new ArrayList();
        ArrayList<User> userList  = new ArrayList();

        bookList.add(new Book(1,"Inferno", "Dan Brown", 2017));
        bookList.add(new Book(2,"You'll Grow Out Of It", "Jessi Klein", 2012));
        bookList.add(new Book(3,"You Are A Badass: How to Stop Doubting Your Greatness and Start Living an Awesome Life", "Jen Sincero", 2012));
        bookList.add(new Book(4,"Learn Python 3 The Hard Way: A Very Simple", "Person", 2012));

        movieList.add(new Movie("1","Harry Potter and the Philosopher's Stone", "Chris Columbu", 2001, 9));
        movieList.add(new Movie("2","The beauty and the beast", " Gary Trousdale", 1991, 2));

        userList.add(new User("321-7654","Harry Potter and the Philosopher's Stone", "rain4$.", "acorream@gmail.com","912345678"));

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        PrintStream output = new PrintStream(System.out);

        BibliotecaApp biblioteca = new BibliotecaApp(bookList, movieList, userList, input, output);

        biblioteca.start();
    }
}