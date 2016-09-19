package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private final Movie movie = new Movie("Mr. Robot","8.7", "Sam Esmail", "2015");

    @Test
    public void FormatsCorrectly() {
        assertEquals("Mr. Robot | 8.7 | Sam Esmail | 2015", movie.toString());
    }

    @Test
    public void MatchesExistingBookTitle() {
        assertTrue(movie.titleMatches("Mr. Robot"));
        assertFalse(movie.titleMatches("I, Robot"));
    }
}
