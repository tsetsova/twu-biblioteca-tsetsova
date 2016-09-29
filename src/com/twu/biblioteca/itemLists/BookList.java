package com.twu.biblioteca.itemLists;

import com.twu.biblioteca.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BookList implements ItemList {

    private LinkedHashMap<Book, String> books = new LinkedHashMap<Book, String>();

    BookList(LinkedHashMap<Book, String> books) {
        this.books = books;
    }

    public BookList() {
        books.put(new Book("The Well-Grounded Rubyist", "David A. Black", "2009"), "available");
        books.put(new Book("Clean Code", "Robert Cecil Martin", "2008"), "available");
        books.put(new Book("The Software Crafstman", "Sandro Mancuso", "2014"), "available");
    }

    public ArrayList<HashMap<String, String>> availableItems() {
        ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
        for (Book book : books.keySet())
            if (books.get(book).equals("available")) items.add(book.details());
        return items;
    }

    boolean isAvailable(String bookName) {
        for (Book book : books.keySet()) {
            if (books.get(book).equals("available") && book.titleMatches(bookName)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkoutItem(String bookName) {
        return updateStatus(bookName, "unavailable");
    }

    public boolean returnItem(String bookName) {
        return updateStatus(bookName, "available");
    }

    private boolean updateStatus(String bookName, String status) {
        for (Book book : books.keySet()) {
            boolean titleMatched = book.titleMatches(bookName);
            if(titleMatched && !books.get(book).equals(status)) {
                books.put(book, status);
                return true;
            }
        }
        return false;
    }
}