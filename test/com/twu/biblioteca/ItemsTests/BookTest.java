package com.twu.biblioteca.ItemsTests;

import com.twu.biblioteca.Items.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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


    @Test
    public void MatchesTitlesCorrectly() {
        assertTrue(book.titleMatches(details.get("Title: ")));
        assertFalse(book.titleMatches("The Ruby Coder"));
    }
}
