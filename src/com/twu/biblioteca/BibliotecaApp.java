package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private final PrintStream out;
    private BufferedReader in;
    private Boolean inputValid;
    private String userNow;

    public BibliotecaApp(ArrayList<Book> listOfBooks, BufferedReader in, PrintStream out) {

        this.bookList = listOfBooks;
        this.out = out;
        this.in = in;
        this.inputValid = true;
        this.userNow = "";
    }

    public void start(){
        this.getWelcomeMessage();
    }

    public void quit(){
        this.out.println("See you next time!");
        this.inputValid = false;
    }

    public void getWelcomeMessage(){
        this.out.println("Welcome To The Biblioteca Library System!");
        this.showMenuOptions();
    }

    public void showMenuOptions() {
        this.out.println("Menu Options:");
        this.out.println("Enter [1] to show all books");
        this.out.println("Enter [2] to checkout book");
        this.out.println("Enter [0] to quit the system");
        this.respondToUserInput();
    }

    public void respondToUserInput() {
        while (this.inputValid) {
            applySelectedMenuOption(getUserInput());
        }
    }

    public void applySelectedMenuOption(Integer input){
        switch (input) {
            case 0:
                this.quit();
                break;
            case 1:
                this.listBooks();
                break;
            case 2:
                this.checkoutBook();
                break;
            default:
                this.out.println("Select a valid option!");
        }
    }

    public Integer getUserInput() {
        Integer input = 0;
        try {
            this.out.print("\nMenu selection: \n");
            input =  Integer.parseInt(in.readLine());
        } catch (Exception e) {
            this.out.println("Select a valid option!");
        }
        return input;
    }

    public void listBooks(){
        String output = "";
        for (Book book : this.bookList){
            if( book.getBorrower() == "") {
                output += book.getBookInfo() + "\n";
            }
        }
        this.out.print(output);
    }

    public void checkoutBook(){
        if(this.userNow != ""){
            String title = this.getBookTitle();
            boolean checkStatus = false;
            for (Book book : this.bookList){
                if(book.getTitle().equals(title) && book.getBorrower() == ""){
                    checkStatus = true;
                    book.setBorrower(this.userNow);
                    this.out.println("\nThank you! Enjoy the book");
                    break;
                }
            }

            if(!checkStatus){
                this.out.println("\nThat book is not available.");
            }
        }
    }

    public String getBookTitle(){
        this.out.print("\nThe book name: \n");
        String title = "";
        try {
            title = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return title;
    }
}