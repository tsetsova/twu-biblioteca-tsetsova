package com.twu.biblioteca.itemLists;

import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.Movie;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class ItemListTest {

        private static LinkedHashMap<Movie, String> movies = new LinkedHashMap<Movie, String>();
        private static LinkedHashMap<Book, String> books = new LinkedHashMap<Book, String>();

        @BeforeClass
        public static void populateLists(){
            movies.put(new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"), "available");
            movies.put(new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"), "available");
            movies.put(new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014"), "available");
            books.put(new Book("The Software Crafstman", "Sandro Mancuso", "2014"), "available");
            books.put(new Book("Clean Code", "Robert Cecil Martin", "2008"), "available");
            books.put(new Book("The Well-Grounded Rubyist", "David A. Black", "2009"), "available");
        }

        private ItemList itemList = new ItemList();

        @Test
        public void TellsIfAnItemIsAvailable() {
//            assertTrue(itemList.isAvailable("Mr. Robot", "movie"));
//            assertFalse(itemList.isAvailable("Many Robots", "movie"));

            assertTrue(itemList.isAvailable("Clean Code", "book"));
            assertFalse(itemList.isAvailable("Unclean Code", "book"));
        }

        @Test
        public void ListsAllItems() {
            assertEquals(3, itemList.availableItems("movie").size());

            assertEquals(3, itemList.availableItems("book").size());
        }

        @Test
        public void ChecksOutAnItem() {
            itemList.checkoutItem("Mr. Robot","movie");
            assertFalse(itemList.isAvailable("Mr. Robot", "movie"));
            assertEquals(2, itemList.availableItems("movie").size());

            itemList.checkoutItem("Clean Code", "book");
            assertFalse(itemList.isAvailable("Clean Code", "book"));
            assertEquals(2, itemList.availableItems("book").size());
        }

        @Test
        public void ReturnsAnItem() {
            itemList.checkoutItem("Mr. Robot", "movie");
            assertTrue(itemList.returnItem("Mr. Robot", "movie"));
            assertTrue(itemList.isAvailable("Mr. Robot", "movie"));
            assertEquals(3, itemList.availableItems("movie").size());

            itemList.checkoutItem("Clean Code", "book");
            assertTrue(itemList.returnItem("Clean Code", "book"));
            assertTrue(itemList.isAvailable("Clean Code","book"));
            assertEquals(3, itemList.availableItems("book").size());
        }

        @Test
        public void OnlyReturnsCheckedOutItem() {
            itemList.returnItem("Many Robots", "movie");
            assertFalse(itemList.returnItem("Many Robots", "movie"));
            assertFalse(itemList.isAvailable("Many Robots", "movie"));
            assertEquals(3, itemList.availableItems("movie").size());

            itemList.returnItem("Coding with Bob", "book");
            assertFalse(itemList.returnItem("Coding with Bob", "book"));
            assertFalse(itemList.isAvailable("Coding with Bob","book"));
            assertEquals(3, itemList.availableItems("book").size());
        }
    }

