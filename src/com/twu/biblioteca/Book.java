package com.twu.biblioteca;

class Book {
    private final String title;
    private final String author;
    private final String publishingYear;

    Book(String title, String author, String publishingYear) {
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public String toString() {
       return title + " | " + author + " | " + publishingYear;
    }

    Boolean titleMatches(String otherTitle) {
        return title.equals(otherTitle);
    }
}
