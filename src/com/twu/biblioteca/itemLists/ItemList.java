package com.twu.biblioteca.itemLists;
import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.Item;
import com.twu.biblioteca.Items.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ItemList {
    private LinkedHashMap<Item, String> books = new LinkedHashMap<Item, String>();
    private LinkedHashMap<Item, String> movies = new LinkedHashMap<Item , String>();

    ItemList(LinkedHashMap<Item, String> books, LinkedHashMap<Item, String> movies ) {
        this.books = books;
        this.movies = movies;
    }

    public ItemList() {
        this.books.put(new Book("The Well-Grounded Rubyist", "David A. Black", "2009"), "available");
        this.books.put(new Book("Clean Code", "Robert Cecil Martin", "2008"), "available");
        this.books.put(new Book("The Software Crafstman", "Sandro Mancuso", "2014"), "available");
        this.movies.put(new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"), "available");
        this.movies.put(new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"), "available");
        this.movies.put(new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014"), "available");
    }

    public ArrayList<HashMap<String, String>> availableItems(String type) {
        ArrayList<HashMap<String, String>> availableListOfItems = new ArrayList<HashMap<String, String>>();
        LinkedHashMap<Item, String> items = determineType(type);
        for (Item item : items.keySet()) {
            if (items.get(item).equals("available")) availableListOfItems.add(item.details());
        }
        return availableListOfItems;
    }

    boolean isAvailable(String title, String type) {
        LinkedHashMap<Item, String> items = determineType(type);
        for (Item item : items.keySet()) {
            if (items.get(item).equals("available") && item.titleMatches(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkoutItem(String title, String type) {
        return updateStatus(title, "unavailable", type);
    }

    public boolean returnItem(String title, String type) {
        return updateStatus(title, "available", type);
    }

    private boolean updateStatus(String title, String status, String type) {
        LinkedHashMap<Item, String> items = determineType(type);
        for (Item item : items.keySet()) {
            boolean titleMatched = item.titleMatches(title);
            if (titleMatched && !items.get(item).equals(status)) {
                items.put(item, status);
                return true;
            }
        }
        return false;
    }

    private LinkedHashMap<Item, String> determineType(String type) {
        if (type.equals("book")) {
            return books;
        } else
            return movies;
    }
}
