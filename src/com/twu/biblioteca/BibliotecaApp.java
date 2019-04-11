package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private final PrintStream out;
    private Scanner scanner;
    private Boolean inputValid;

    public BibliotecaApp(ArrayList<Book> listOfBooks, InputStream in, PrintStream out) {
        this.bookList = listOfBooks;
        this.out = out;
        this.scanner = new Scanner(in);
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
            input = this.scanner.nextInt();
        } catch (Exception e) {

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
        this.out.println("See you later");
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

        BibliotecaApp biblioteca = new BibliotecaApp(bookList, System.in, new PrintStream(System.out));

        biblioteca.start();
    }

}