package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private ArrayList<Book> bookList;
    private Book Inferno;
    private InputStream in;
    private PrintStream out;

    @Before
    public void setUp(){
        bookList = new ArrayList();
        in = mock(InputStream.class);
        out = mock(PrintStream.class);
        Inferno = mock(Book.class);
        bibliotecaApp = new BibliotecaApp(bookList,in,out);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStart(){
        bibliotecaApp.start();
        verify(out).println(contains("Welcome"));
    }
}