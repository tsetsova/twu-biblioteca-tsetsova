package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class MovieList implements ItemList {

    private ArrayList<Movie> availableMovies = new ArrayList<Movie>();
    private ArrayList<Movie> checkedOutMovies = new ArrayList<Movie>();

    public boolean isAvailable(String movieName) {
        return isInList(movieName, availableMovies);
    }

    MovieList() {
        availableMovies = new ArrayList<Movie>(Arrays.asList(
                new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"),
                new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"),
                new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014")));
    }

    MovieList(ArrayList<Movie> listOfMovies) { availableMovies = listOfMovies; }

    ArrayList<Movie> allMovies() {
        return availableMovies;
    }

    public void checkout(String movieName) {
        if(!isAvailable(movieName)) return;

        Movie checkedOutMovie = findMovie(movieName, availableMovies);
        checkedOutMovies.add(checkedOutMovie);
        availableMovies.remove(checkedOutMovie);

    }

    private Movie findMovie(String movieName, ArrayList<Movie> availableMovies) {
        for(Movie movie : availableMovies) {
            if (movie.titleMatches(movieName)) {return movie;}
        }
        return null;
    }


    private boolean isInList(String movieName, ArrayList<Movie> movies) {
        for(Movie movie : movies) {
            if( movie.titleMatches(movieName)) return true;
        }
        return false;
    }
}
