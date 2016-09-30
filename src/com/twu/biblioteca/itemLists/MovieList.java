package com.twu.biblioteca.itemLists;

import com.twu.biblioteca.Items.Movie;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieList implements ItemListInterface {

    private ArrayList<Movie> availableMovies = new ArrayList<Movie>();
    private ArrayList<Movie> checkedOutMovies = new ArrayList<Movie>();

    public boolean isMovieAvailable(String movieName) {
        return isInList(movieName, availableMovies);
    }

    public MovieList() {
        availableMovies = new ArrayList<Movie>(Arrays.asList(
                new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"),
                new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"),
                new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014")));
    }

    MovieList(ArrayList<Movie> listOfMovies) { availableMovies = listOfMovies; }

    public ArrayList<Movie> allMovies() {
        return availableMovies;
    }

    public void checkout(String movieName) {
        if(!isMovieAvailable(movieName)) return;

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

    @Override
    public boolean checkoutItem(String name) {
        return false;
    }

    @Override
    public boolean returnItem(String bookName) {
        return false;
    }
}
