package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private ArrayList<User> userList;
    private final PrintStream out;
    private Boolean inputValid;
    private BufferedReader in;
    private String userNow;

    public BibliotecaApp(ArrayList<Book> listOfBooks, ArrayList<User> listOfUsers, BufferedReader in, PrintStream out) {
        this.bookList = listOfBooks;
        this.userList = listOfUsers;
        this.out = out;
        this.in = in;
        this.inputValid = true;
        this.userNow = "";
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
        this.out.println("Enter [2] to checkout book");
        this.out.println("Enter [3] to return book");
        this.out.println("Enter [0] to show quit the system");
        this.respondToUserInput();
    }

    public void respondToUserInput() {
        while (this.inputValid) {
            applySelectedMenuOption(getUserInput());
        }
    }

    private void applySelectedMenuOption(Integer input) {
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
            case 3:
                this.returnBook();
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
        this.loginCheck();
        if(this.userNow != ""){
            String title = this.getBookTitle();
            boolean checkStatus = false;
            for (Book book : this.bookList){
                if(book.getTitle().equals(title) && book.getBorrower() == ""){
                    checkStatus = true;
                    book.setBorrower(this.userNow);
                    this.out.println("Thank you! Enjoy the book");
                    break;
                }
            }

            if(!checkStatus){
                this.out.println("That book is not available.");
            }
        }
    }

    public void returnBook(){
        this.loginCheck();
        if(this.userNow != ""){
            String title = this.getBookTitle();
            boolean checkStatus = false;
            for (Book book : this.bookList){
                if(book.getTitle().equals(title) && book.getBorrower() != ""){
                    checkStatus = true;
                    book.setBorrower("");
                    this.out.println("\nThank you for returning the book.");
                    break;
                }
            }

            if(!checkStatus){
                this.out.println("\nThat is not a valid book to return.");
            }
        }
    }

    public void loginCheck(){
        if ( this.userNow == ""){
            this.login(this.getUserId(),this.getUserPassword());
        }
    }

    public void login(String userNumber, String password){
        boolean validNumber = false;
        for (User user : this.userList){
            if (user.getId().equals(userNumber)){
                validNumber = true;
                if(user.getPassword().equals(password)){
                    this.userNow = user.getId();
                    break;
                }else{
                    this.out.print("\nInvalid password: \n");
                }
            }
        }

        if(!validNumber){
            this.out.print("\nInvalid user ID: \n");
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

    public String getUserId(){
        this.out.print("\nUser ID: \n");
        String number = "";
        try {
            number = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return number;
    }

    public String getUserPassword(){
        this.out.print("\nPassword: \n");
        String password = "";
        try {
            password = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return password;
    }


}