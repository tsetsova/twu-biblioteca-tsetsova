package com.twu.biblioteca;

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

    public String toString() {
        return title + " | " + rating + " | "+ director + " | " + releaseYear;
    }

    @Override
    public String getTitle() {
        return null;
    }

    public Boolean titleMatches(String otherTitle) {
        return title.equals(otherTitle);
    }

    @Override
    public HashMap<String, String> details() {
        return null;
    }
}
