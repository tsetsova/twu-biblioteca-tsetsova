package com.twu.biblioteca.Items;
import java.util.LinkedHashMap;

public class Book extends Item{
    private final String author;
    private final String publishingYear;

    public Book(String title, String author, String publishingYear) {
        super(title);
        this.author = author;
        this.publishingYear = publishingYear;
    }

    @Override
    public LinkedHashMap<String, String> details() {
        LinkedHashMap<String, String> bookDetails = new LinkedHashMap<String, String>();
        bookDetails.put("Title: ", super.getTitle());
        bookDetails.put("Author: ", author);
        bookDetails.put("Publishing year: ", publishingYear);
        return bookDetails;
    }
}

