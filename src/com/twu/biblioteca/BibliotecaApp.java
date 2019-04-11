package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private final PrintStream out;
    private Boolean inputValid;
    private BufferedReader in;

    public BibliotecaApp(ArrayList<Book> listOfBooks, BufferedReader in, PrintStream out) {
        this.bookList = listOfBooks;
        this.out = out;
        this.in = in;
        this.inputValid = true;
    }

    private void applySelectedMenuOption(Integer input) {
        switch (input) {
            case 0:
                this.quit();
                break;
            case 1:
                this.listBooks(this.bookList);
                break;
            default:
                this.out.println("Select a valid option!");
        }
    }

    private Integer getUserInput() {
        Integer input = 0;
        try {
            this.out.print("\nMenu selection: \n");
            input = Integer.parseInt(in.readLine());
        }  catch (Exception e) {
            this.out.println("Select a valid option!");
        }
        return input;
    }

    public void respondToUserInput() {
        while (this.inputValid) {
            applySelectedMenuOption(getUserInput());
        }
    }

    public void start(){
        this.getWelcomeMessage();
    }

    public void quit(){
        this.out.println("Goodbye");
        this.inputValid = false;
    }

    public void getWelcomeMessage(){
        this.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!.");
        this.showMenuOptions();
    }

    public void showMenuOptions() {
        this.out.println("Menu Options:");
        this.out.println("Enter [1] to show all books");
        this.out.println("Enter [0] to show quit the system");
        this.respondToUserInput();
    }

    public void listBooks(ArrayList<Book> bookList){
        String output = "";
        for (Book book : bookList){
            output += book.getBookInfo() + "\n";
        }
        this.out.print(output);
    }

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();
        bookList.add(new Book("Inferno", "Dan Brown", 2014));
        bookList.add(new Book("You'll Grow Out Of It", "Jessi Klein", 2016));
        bookList.add(new Book("You Are A Badass: How to Stop Doubting Your Greatness and Start Living an Awesome Life", "Jen Sincero", 2013));
        bookList.add(new Book("Learn Python 3 The Hard Way: A Very Simple", "Zed A. Shaw", 2017));

        BibliotecaApp biblioteca = new BibliotecaApp(bookList, new BufferedReader(new InputStreamReader(System.in)), new PrintStream(System.out));
        biblioteca.start();
    }

}