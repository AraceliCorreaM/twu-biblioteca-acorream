package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<User> userList;
    private final PrintStream out;
    private BufferedReader in;
    private Boolean inputValid;
    private String userNow;

    public BibliotecaApp(ArrayList<Book> listOfBooks, ArrayList<Movie> listOfMovies, ArrayList<User> listOfUsers, BufferedReader in, PrintStream out) {

        this.bookList = listOfBooks;
        this.movieList = listOfMovies;
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
        this.out.println("Goodbye!");
        this.inputValid = false;
    }

    public void getWelcomeMessage(){
        this.out.println("Welcome to Biblioteca System. Your one-stop-shop for great book titles in Bangalore!.");
        this.showMenuOptions();
    }

    public void showMenuOptions() {
        this.out.println("Menu Options:");
        this.out.println("Enter 1 to show all books");
        this.out.println("Enter 2 to checkout a book");
        this.out.println("Enter 3 to return a book");
        this.out.println("Enter 4 to show all movies");
        this.out.println("Enter 5 to checkout a movie");
        this.out.println("Enter 6 to return a movie");
        this.out.println("Enter 0 to quit the System");
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
            case 3:
                this.returnBook();
                break;
            case 4:
                this.listMovies();
                break;
            case 5:
                this.checkoutMovie();
                break;
            case 6:
                this.returnMovie();
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
            this.out.println("Enter a valid option! \n");
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

    public void listMovies(){
        String output = "";
        for (Movie movie : this.movieList){
            if( movie.getBorrower() == "") {
                output += movie.getMovieInfo() + "\n";
            }
        }
        this.out.print(output);
    }

    public void checkoutBook(){
        this.loginCheck();
        if(this.userNow != ""){
            this.out.print("\nWhich book do you want to check out? \n");
            String title = this.getBookTitle();
            boolean checkStatus = false;
            for (Book book : this.bookList){
                if(book.getBookTitle().equals(title) && book.getBorrower() == ""){
                    checkStatus = true;
                    book.setBorrower(this.userNow);
                    this.out.println("\nThank you! Enjoy the book.");
                    break;
                }
            }

            if(!checkStatus){
                this.out.println("\nThat book is not available.");
            }
        }
    }

    public void returnBook(){
        this.loginCheck();
        if(this.userNow != ""){
            this.out.print("\nWhich book do you want to return? \n");
            String title = this.getBookTitle();
            boolean checkStatus = false;
            for (Book book : this.bookList){
                if(book.getBookTitle().equals(title) && book.getBorrower() != ""){
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

    public void checkoutMovie(){
        this.loginCheck();
        if(this.userNow != ""){
            this.out.print("\nWhich movie do you want to check out? \n");
            String name = this.getMovieName();
            boolean checkStatus = false;
            for (Movie movie : this.movieList){
                if(movie.getMovieName().equals(name) && movie.getBorrower() == ""){
                    checkStatus = true;
                    movie.setBorrower(this.userNow);
                    this.out.println("\nThank you! Enjoy the book");
                    break;
                }
            }

            if(!checkStatus){
                this.out.println("\nThat book is not available.");
            }
        }
    }

    public void returnMovie(){
        this.loginCheck();
        if(this.userNow != ""){
            this.out.print("\nWhich movie do you want to returnt? \n");
            String name = this.getMovieName();
            boolean checkStatus = false;
            for (Movie movie : this.movieList){
                if(movie.getMovieName().equals(name) && movie.getBorrower() != ""){
                    checkStatus = true;
                    movie.setBorrower("");
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
        else {
            this.out.println("You need to login to use Biblioteca.");
        }
    }

    public void login(String userId, String password){
        boolean validId = false;
        for (User user : this.userList){
            if (user.getUserId().equals(userId)){
                validId = true;
                if(user.getPassword().equals(password)){
                    this.userNow = user.getUserId();
                    break;
                }else{
                    this.out.print("\nInvalid Password, enter again! \n");
                }
            }
        }
        if(!validId){
            this.out.print("\nInvalid user ID, enter again! \n");
        }
    }

    public String getBookTitle(){
        this.out.print("\nBook title:  \n");
        String title = "";
        try {
            title = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return title;
    }

    public String getMovieName(){
        this.out.print("\nMovie name:  \n");
        String name = "";
        try {
            name = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return name;
    }


    public String getUserId(){
        this.out.print("\nYour user ID: \n");
        String id = "";
        try {
            id = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public String getUserPassword() {
        this.out.print("\nYour password: \n");
        String password = "";
        try {
            password = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
}