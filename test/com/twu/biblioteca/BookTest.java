package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book(1,"Inferno", "Dan Brown", 2014);
    }

    @Test
    public void shouldConvertDetailsToString() {
        assertEquals(String.format("%-30s | %-30s | %d","Inferno", "Dan Brown", 2014), book.getBookInfo());
    }
}