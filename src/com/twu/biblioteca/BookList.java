package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Arrays;

class BookList {

    private ArrayList<Book> availableBooks = new ArrayList<Book>();

    BookList() {
        availableBooks = new ArrayList<Book>(Arrays.asList(
                new Book("The Well-Grounded Rubyist","David A. Black","2009"),
                new Book("Clean Code","Robert Cecil Martin","2008"),
                new Book("The Software Crafstman","Sandro Mancuso","2014")));
    }

    BookList(ArrayList<Book> listOfBooks) {
        this.availableBooks = listOfBooks;
    }

    boolean isBookAvailable(String bookName) {
        for(Book book : availableBooks) {
            if(book.titleMatches(bookName)) return true;
        }
        return false;
    }

    void checkout(String bookName) {
        Book checkedOutBook = findBook(bookName);

        availableBooks.remove(checkedOutBook);
    }

    ArrayList<Book> allBooks() {
        return availableBooks;
    }

    private Book findBook(String bookName) {
        for(Book book : availableBooks) {
            if (book.titleMatches(bookName)) { return book; }
        }
        return null;
    }
}