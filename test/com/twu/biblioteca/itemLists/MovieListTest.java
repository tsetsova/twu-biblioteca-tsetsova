package com.twu.biblioteca.itemLists;

import com.twu.biblioteca.Items.Item;
import com.twu.biblioteca.Items.Movie;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class MovieListTest {

    private static LinkedHashMap<Item, String> movieInformation = new LinkedHashMap<Item, String>();

    @BeforeClass
    public static void populateMovieList(){
        movieInformation.put(new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"), "available");
        movieInformation.put(new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"), "available");
        movieInformation.put(new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014"), "available");
    }


    private ItemList movieList = new ItemList(movieInformation);

    @Test
    public void TellsIfABookIsAvailable() {
        assertTrue(movieList.isAvailable("Mr. Robot"));
        assertFalse(movieList.isAvailable("Many Robots"));
    }

    @Test
    public void ListsAllMovie() {
        assertEquals(3, movieList.availableItems().size());
    }

    @Test
    public void ChecksOutAMovie() {
        movieList.checkoutItem("Mr. Robot");
        assertFalse(movieList.isAvailable("Mr. Robot"));
        assertEquals(2, movieList.availableItems().size());
    }


    @Test
    public void ReturnsAMovie() {
        movieList.checkoutItem("Mr. Robot");
        assertTrue(movieList.returnItem("Mr. Robot"));
        assertTrue(movieList.isAvailable("Mr. Robot"));
        assertEquals(3, movieList.availableItems().size());
    }

    @Test
    public void OnlyReturnsCheckedOutMovies() {
        movieList.returnItem("Many Robots");
        assertFalse(movieList.returnItem("Many Robots"));
        assertFalse(movieList.isAvailable("Many Robots"));
        assertEquals(3, movieList.availableItems().size());
    }
}
