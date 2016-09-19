package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by inatsetsova on 19/09/2016.
 */
public class MovieListTest {

    ArrayList<Movie> listOfMovies = new ArrayList<Movie> (Arrays.asList(new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"),
                                                                        new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016")));

    private final MovieList movieList = new MovieList(listOfMovies);

    @Test
    public void ListsAllBook() {
    assertEquals(listOfMovies, movieList.allMovies());
}
}
