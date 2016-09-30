package com.twu.biblioteca.itemLists;

import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.Item;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class BookListTest {

    private static LinkedHashMap<Item, String> bookInformation = new LinkedHashMap<Item, String>();

    @BeforeClass
        public static void populateBookList(){
            bookInformation.put(new Book("The Software Crafstman", "Sandro Mancuso", "2014"), "available");
            bookInformation.put(new Book("Clean Code", "Robert Cecil Martin", "2008"), "available");
            bookInformation.put(new Book("The Well-Grounded Rubyist", "David A. Black", "2009"), "available");
        }


    private ItemList bookList = new ItemList(bookInformation);

    @Test
    public void TellsIfABookIsAvailable() {
        assertTrue(bookList.isAvailable("Clean Code"));
        assertFalse(bookList.isAvailable("Unclean Code"));
    }

    @Test
    public void ListsAllBook() {
        assertEquals(3, bookList.availableItems().size());
    }

    @Test
    public void ChecksOutABook() {
        bookList.checkoutItem("Clean Code");
        assertFalse(bookList.isAvailable("Clean Code"));
        assertEquals(2, bookList.availableItems().size());
    }


    @Test
    public void ReturnsABook() {
        bookList.checkoutItem("Clean Code");
        assertTrue(bookList.returnItem("Clean Code"));
        assertTrue(bookList.isAvailable("Clean Code"));
        assertEquals(3, bookList.availableItems().size());
    }

    @Test
    public void OnlyReturnsCheckedOutBooks() {
        bookList.returnItem("Coding with Bob");
        assertFalse(bookList.returnItem("Coding with Bob"));
        assertFalse(bookList.isAvailable("Coding with Bob"));
        assertEquals(3, bookList.availableItems().size());
    }
}
