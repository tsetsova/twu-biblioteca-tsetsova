package com.twu.biblioteca.ItemsTests;

import com.twu.biblioteca.Items.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    private final Movie movie = new Movie("Mr. Robot","8.7", "Sam Esmail", "2015");

    private HashMap<String, String> details = new HashMap<String, String>();

    @Before
    public void populateList() {
        details.put("Title: ", "Mr. Robot");
        details.put("Rating: ", "8.7");
        details.put("Director: ", "Sam Esmail");
        details.put("Release Year: ", "2015");
    }

    @Test
    public void MatchesBookDetails() {
        assertEquals(details,movie.details());
    }

    @Test
    public void MatchesTitlesCorrectly() {
        assertTrue(movie.titleMatches(details.get("Title: ")));
        assertFalse(movie.titleMatches("Robot people"));
    }
}
