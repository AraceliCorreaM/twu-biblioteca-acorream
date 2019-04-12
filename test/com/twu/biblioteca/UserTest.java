package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void setUp() {
        user = new User("321-7654","acorream", "rain4$.", "acorream@gmail.com","912345678");
    }

    @Test
    public void shouldGetId() {
        assertEquals("321-7654", user.getUserId());
    }

    @Test
    public void shouldGetPassword() {
        assertEquals("rain4$.", user.getPassword());
    }

    @Test
    public void shouldGetUserInfoInFormat() {
        assertEquals(String.format("%-20s | %-20s | %-20s | %-20s | %-20s", "321-7654", "acorream", "rain4$.", "acorream@gmail.com","912345678"), user.getUserInfo());
    }

}