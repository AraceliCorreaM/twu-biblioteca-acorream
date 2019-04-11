package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    //private BufferedReader in;
    //private PrintStream out;

    @Before
    public void setUp(){

        //in = mock(BufferedReader.class);
        //out = mock(PrintStream.class);
        //bibliotecaApp = new BibliotecaApp(in,out);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStart() throws IOException{
        //when(in.readLine()).thenReturn("0");
        //bibliotecaApp.start();
        //verify(out).println(contains("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!."));
    }
}