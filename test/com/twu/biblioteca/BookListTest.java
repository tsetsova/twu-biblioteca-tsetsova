package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BookListTest {

    private ArrayList<Book> listOfBooks = new ArrayList<Book>(Arrays.asList(
                                            new Book("The Well-Grounded Rubyist","David A. Black","2009"),
                                            new Book("Clean Code","Robert Cecil Martin","2008")));
    private final BookList bookList = new BookList(listOfBooks);

    @Test
    public void TellsIfABookIsAvailable() {
        assertTrue(bookList.isAvailable("Clean Code"));
        assertFalse(bookList.isAvailable("Unclean Code"));
    }

    @Test
    public void ChecksOutABook() {
        bookList.checkout("Clean Code");
        assertFalse(bookList.isAvailable("Clean Code"));
        assertEquals(1, bookList.allBooks().size());
    }

    @Test
    public void ListsAllBook() {
        assertEquals(listOfBooks, bookList.allBooks());
    }

    @Test
    public void ReturnsABook() {
        bookList.checkout("Clean Code");
        bookList.returnBook("Clean Code");
        assertTrue(bookList.isAvailable("Clean Code"));
        assertEquals(2, bookList.allBooks().size());
    }

    @Test
    public void OnlyReturnsCheckedOutBooks() {
        bookList.returnBook("Coding with Bob");
        assertFalse(bookList.isAvailable("Coding with Bob"));
        assertEquals(2, bookList.allBooks().size());
    }
}
