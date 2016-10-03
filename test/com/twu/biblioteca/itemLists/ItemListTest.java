package com.twu.biblioteca.itemLists;

import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.Movie;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class ItemListTest {

        private static LinkedHashMap<Movie, String> movies = new LinkedHashMap<>();
        private static LinkedHashMap<Book, String> books = new LinkedHashMap<>();

        @BeforeClass
        public static void populateLists(){
            movies.put(new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"), "available");
            movies.put(new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"), "available");
            movies.put(new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014"), "available");
        }

        private ItemList itemList = new ItemList();

        @Test
        public void TellsIfAnItemIsAvailable() {
            assertTrue(itemList.isAvailable("Mr. Robot", "movie"));
            assertFalse(itemList.isAvailable("Many Robots", "movie"));
        }

        @Test
        public void ListsAllItems() {
            assertEquals(3, itemList.availableItems("movie").size());
        }

        @Test
        public void ChecksOutAnItem() {
            itemList.checkoutItem("Mr. Robot","movie");
            assertFalse(itemList.isAvailable("Mr. Robot", "movie"));
            assertEquals(2, itemList.availableItems("movie").size());
        }

        @Test
        public void ReturnsAnItem() {
            itemList.checkoutItem("Mr. Robot", "movie");
            assertTrue(itemList.returnItem("Mr. Robot", "movie"));
            assertTrue(itemList.isAvailable("Mr. Robot", "movie"));
            assertEquals(3, itemList.availableItems("movie").size());
        }

        @Test
        public void OnlyReturnsCheckedOutItem() {
            itemList.returnItem("Many Robots", "movie");
            assertFalse(itemList.returnItem("Many Robots", "movie"));
            assertFalse(itemList.isAvailable("Many Robots", "movie"));
            assertEquals(3, itemList.availableItems("movie").size());
        }
    }

