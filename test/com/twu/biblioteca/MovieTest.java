package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("1","Harry Potter", "sdsd", 2007, 9);
    }

    @Test
    public void shouldGetMoiveName() {
        assertEquals("Transformers", movie.getMovieName());
    }

    @Test
    public void shouldGetMovieBorrower() {
        assertEquals("", movie.getBorrower());
    }

    @Test
    public void shouldGetMovieInfoInFormat()  {
        assertEquals(String.format("%-30s | %-20s | %d | %d", "Transformers", "Michael Benjamin Bay ", 2007, 9), movie.getMovieInfo());
    }

    @Test
    public void shouldSetMovieBorrower() {
        movie.setBorrower("100-10001");
        assertEquals("100-10001", movie.getBorrower());
    }

}