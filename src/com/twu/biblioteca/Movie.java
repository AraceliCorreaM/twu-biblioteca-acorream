package com.twu.biblioteca;

public class Movie {
    private String id;
    private String name;
    private String director;
    private int year;
    private int rating;
    private String borrower;

    public Movie(String id,String name, String director, int year, int rating) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.borrower = "";
    }

    public String getMovieName(){
        return this.name;
    }

    public String getBorrower(){
        return this.borrower;
    }

    public String getMovieInfo() {
        return String.format("%-30s | %-30s | %d | %d", name, director, year, rating);
    }

    public void setBorrower(String borrower){
        this.borrower = borrower;
    }


}