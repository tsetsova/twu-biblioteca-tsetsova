package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MovieListTest {

    private ArrayList<Movie> listOfMovies = new ArrayList<Movie> (Arrays.asList(new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"),
                                                                        new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016")));

    private final MovieList movieList = new MovieList(listOfMovies);

    @Test
    public void ListsAllBook() {
    assertEquals(listOfMovies, movieList.allMovies());
}


    @Test
    public void TellsIfABookIsAvailable() {
        assertTrue(movieList.isAvailable("Mr. Robot"));
        assertFalse(movieList.isAvailable("I, Robot"));
    }

    @Test
    public void ChecksOutABook() {
        movieList.checkout("Mr. Robot");
        assertFalse(movieList.isAvailable("Mr. Robot"));
        assertEquals(1, movieList.allMovies().size());
    }

}
