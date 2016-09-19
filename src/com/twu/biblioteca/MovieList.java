package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieList {

    private ArrayList<Movie> movies = new ArrayList<Movie>();

    MovieList() {
        movies = new ArrayList<Movie>(Arrays.asList(
                new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"),
                new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"),
                new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014")));
    }

    MovieList(ArrayList<Movie> listOfMovies) { movies = listOfMovies; }

    ArrayList<Movie> allMovies() {
        return movies;
    }
}
