package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("1","Harry Potter and the Philosopher's Stone", "Chris Columbus", 2001, 9);
    }

    @Test
    public void shouldGetMoiveName() {
        assertEquals("Harry Potter and the Philosopher's Stone", movie.getMovieName());
    }

    @Test
    public void shouldGetMovieBorrower() {
        assertEquals("", movie.getBorrower());
    }

    @Test
    public void shouldGetMovieInfoInFormat()  {
        assertEquals(String.format("%-30s | %-30s | %d | %d", "Harry Potter and the Philosopher's Stone", "Chris Columbus", 2001, 9), movie.getMovieInfo());
    }

    @Test
    public void shouldSetMovieBorrower() {
        movie.setBorrower("100-10001");
        assertEquals("100-10001", movie.getBorrower());
    }

}