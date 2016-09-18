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
        assertTrue(bookList.isBookAvailable("Clean Code"));
        assertFalse(bookList.isBookAvailable("Unclean Code"));
    }

    @Test
    public void ChecksOutABook() {
        bookList.checkout("Clean Code");
        assertFalse(bookList.isBookAvailable("Clean Code"));
        assertEquals(1, bookList.allBooks().size());
    }

    @Test
    public void ListsAllBook() {
        assertEquals(listOfBooks, bookList.allBooks());
    }
}
