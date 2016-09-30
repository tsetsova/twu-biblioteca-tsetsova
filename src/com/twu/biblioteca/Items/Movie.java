package com.twu.biblioteca.Items;
import java.util.LinkedHashMap;

public class Movie extends Item {
    private String rating;
    private String director;
    private String releaseYear;

    public Movie(String title, String rating, String director, String releaseYear) {
        super(title);
        this.rating = rating;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    @Override
    public LinkedHashMap<String, String> details() {
        LinkedHashMap<String, String> movieDetails = new LinkedHashMap<String, String>();
        movieDetails.put("Title: ", super.getTitle());
        movieDetails.put("Rating: ", rating);
        movieDetails.put("Director: ", director);
        movieDetails.put("Release Year: ", releaseYear);
        return movieDetails;
    }
}
