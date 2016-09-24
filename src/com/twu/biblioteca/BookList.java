package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Arrays;

class BookList implements ItemList {

    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    BookList() {
        availableBooks = new ArrayList<Book>(Arrays.asList(
                new Book("The Well-Grounded Rubyist","David A. Black","2009"),
                new Book("Clean Code","Robert Cecil Martin","2008"),
                new Book("The Software Crafstman","Sandro Mancuso","2014")));
    }

    BookList(ArrayList<Book> listOfBooks) {
        this.availableBooks = listOfBooks;
    }


    ArrayList<Book> allBooks() { return availableBooks; }

    public boolean isAvailable(String bookName) {
        return isInList(bookName, availableBooks);
    }

    boolean isBookCheckedOut(String bookName) {
        return isInList(bookName, checkedOutBooks);
    }

    public void checkout(String bookName) {
        if (!isAvailable(bookName)) return;

        Book checkedOutBook = findBook(bookName, availableBooks);
        checkedOutBooks.add(checkedOutBook);
        availableBooks.remove(checkedOutBook);
    }

    void returnBook(String bookName) {
        if (!isBookCheckedOut(bookName)) return;

        Book returnedBook = findBook(bookName, checkedOutBooks);
        checkedOutBooks.remove(returnedBook);
        availableBooks.add(returnedBook);
    }

    private Book findBook(String bookName, ArrayList<Book> books) {
        for(Book book : books) {
            if (book.titleMatches(bookName)) { return book; }
        }
        return null;
    }

    private boolean isInList(String bookName, ArrayList<Book> books) {
        for(Book book : books) {
            if(book.titleMatches(bookName)) return true;
        }
        return false;
    }
}