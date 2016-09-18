package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private final Book book = new Book("The Well-Grounded Rubyist","David A. Black","2009");

    @Test
    public void FormatsCorrectly() {
        assertEquals("The Well-Grounded Rubyist | David A. Black | 2009", book.toString());
    }

    @Test
    public void MatchesExistingBookTitle() {
        assertTrue(book.titleMatches("The Well-Grounded Rubyist"));
        assertFalse(book.titleMatches("Coding with Bob"));
    }
}
