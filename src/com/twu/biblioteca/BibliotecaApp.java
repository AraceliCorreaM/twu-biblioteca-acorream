package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {
    private static BibliotecaApp biblioteca;
    private final PrintStream out;
    private BufferedReader in;

    public BibliotecaApp(BufferedReader in, PrintStream out) {
        this.out = out;
        this.in = in;
    }

    public void start() {
        this.getWelcomeMessage();
    }

    public void getWelcomeMessage() {
        //System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!.");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!.");
    }
}