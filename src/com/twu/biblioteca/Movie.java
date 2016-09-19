package com.twu.biblioteca;

public class Movie {

    private String title;
    private String rating;
    private String director;
    private String releaseYear;

    Movie(String title, String rating, String director, String releaseYear) {
        this.title = title;
        this.rating = rating;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String toString() {
        return title + " | " + rating + " | "+ director + " | " + releaseYear;
    }
}
