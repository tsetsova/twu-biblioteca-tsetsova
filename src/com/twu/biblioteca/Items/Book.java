package com.twu.biblioteca.Items;

import java.util.HashMap;

public class Book implements Item {
    private final String title;
    private final String author;
    private final String publishingYear;

    public Book(String title, String author, String publishingYear) {
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public String getTitle() {return title;}

    public Boolean titleMatches(String otherTitle) {return title.equals(otherTitle);}

    public HashMap<String, String> details() {
        HashMap<String, String> bookDetails = new HashMap<String, String>();
        bookDetails.put("Title: ", title);
        bookDetails.put("Author: ", author);
        bookDetails.put("Publishing year: ", publishingYear);
        return bookDetails;
    }
}

