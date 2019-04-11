package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private ArrayList<Book> bookList;
    private Book Inferno;
    private BufferedReader in;
    private PrintStream out;

    @Before
    public void setUp(){
        bookList = new ArrayList();
        in = mock(BufferedReader.class);
        out = mock(PrintStream.class);
        Inferno = mock(Book.class);
        bibliotecaApp = new BibliotecaApp(bookList, in, out);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStart(){
        bibliotecaApp.start();
        verify(out).println(contains("Welcome"));
    }

    @Test
    public void shouldShowMenuOptionsWhenMenuIsShow(){
        bibliotecaApp.start();
        verify(out).println(contains("Enter [1] to show all books"));
    }

    @Test
    public void shouldGetBookInfoWhenInputsOne() throws IOException{
        when(in.readLine()).thenReturn("1");
        bookList.add(Inferno);
        bibliotecaApp.start();
        verify(Inferno).getBookInfo();
    }

    @Test
    public void shouldQuitAndSayGoodByeWhenInputZero() throws IOException{
        when(in.readLine()).thenReturn("0");
        bibliotecaApp.start();
        verify(out).println(contains("Goodbye"));
    }

    @Test
    public void shouldReportErroWhenInputIsNotInteger() throws IOException{
        when(in.readLine()).thenReturn("XXXXXX").thenReturn("1");
        bookList.add(Inferno);
        bibliotecaApp.start();
        verify(out).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldReportErrorWhenInvalidOptionSelected() throws IOException{
        when(in.readLine()).thenReturn("-1").thenReturn("1");
        bookList.add(Inferno);
        bibliotecaApp.start();
        verify(out).println(contains("Select a valid option!"));
    }
}