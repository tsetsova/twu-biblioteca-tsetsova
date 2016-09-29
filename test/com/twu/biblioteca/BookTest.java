package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private final Book book = new Book("The Well-Grounded Rubyist","David A. Black","2009");
    private HashMap<String, String> details = new HashMap<String, String>();

    @Before
    public void populateList() {
        details.put("Title: ","The Well-Grounded Rubyist");
        details.put("Author: ", "David A. Black");
        details.put("Publishing year: ", "2009");
    }

    @Test
    public void MatchesBookDetails() {
        assertEquals(details,book.details());
    }
}
