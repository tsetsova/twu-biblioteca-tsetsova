package com.twu.biblioteca.Items;

import java.util.HashMap;

public class Movie implements Item{

    private String title;
    private String rating;
    private String director;
    private String releaseYear;

    public Movie(String title, String rating, String director, String releaseYear) {
        this.title = title;
        this.rating = rating;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public Boolean titleMatches(String otherTitle) {
        return title.equals(otherTitle);
    }

    public HashMap<String, String> details() {
        HashMap<String, String> movieDetails = new HashMap<String, String>();
        movieDetails.put("Title: ", title);
        movieDetails.put("Rating: ", rating);
        movieDetails.put("Director: ", director);
        movieDetails.put("Release Year: ", releaseYear);
        return movieDetails;
    }
}
