//package com.twu.biblioteca.itemLists;
//
//import com.twu.biblioteca.Items.Book;
//import com.twu.biblioteca.Items.Item;
//import com.twu.biblioteca.Items.Movie;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//
//public class MovieList implements ItemListInterface {
//
//    private ArrayList<Movie> availableMovies = new ArrayList<Movie>();
//    private ArrayList<Movie> checkedOutMovies = new ArrayList<Movie>();
//
//    public boolean isMovieAvailable(String movieName) {
//        return isInList(movieName, availableMovies);
//    }
//
//    public MovieList() {
//        availableMovies = new ArrayList<Movie>(Arrays.asList(
//                new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"),
//                new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"),
//                new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014")));
//    }
//
//    private LinkedHashMap<Item, String> items = new LinkedHashMap<Item, String>();
//
////    private void populat ItemList() {
//        items.put(new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"), "available");
//        items.put(new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"), "available");
//        items.put(new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014"), "available");
//    }
//
//    public ArrayList<HashMap<String, String>> availableItems() {
//        ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
//        for (Item item : this.items.keySet())
//            if (this.items.get(item).equals("available")) items.add(item.details());
//        return items;
//    }
//
//    MovieList(ArrayList<Movie> listOfMovies) { availableMovies = listOfMovies; }
//
//    public ArrayList<Movie> allMovies() {
//        return availableMovies;
//    }
//
//    public void checkout(String movieName) {
//        if(!isMovieAvailable(movieName)) return;
//
//        Movie checkedOutMovie = findMovie(movieName, availableMovies);
//        checkedOutMovies.add(checkedOutMovie);
//        availableMovies.remove(checkedOutMovie);
//
//    }
//
//    private Movie findMovie(String movieName, ArrayList<Movie> availableMovies) {
//        for(Movie movie : availableMovies) {
//            if (movie.titleMatches(movieName)) {return movie;}
//        }
//        return null;
//    }
//
//
//    private boolean isInList(String movieName, ArrayList<Movie> movies) {
//        for(Movie movie : movies) {
//            if( movie.titleMatches(movieName)) return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean checkoutItem(String name) {
//        return false;
//    }
//
//    @Override
//    public boolean returnItem(String bookName) {
//        return false;
//    }
//}

package com.twu.biblioteca.itemLists;
import com.twu.biblioteca.Items.Item;
import com.twu.biblioteca.Items.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MovieList implements ItemListInterface {

    private LinkedHashMap<Item, String> items = new LinkedHashMap<Item, String>();

    MovieList(LinkedHashMap<Item, String> items) {
        this.items = items;
    }

    public MovieList() {
        items.put(new Movie("Mr. Robot","8.7", "Sam Esmail", "2015"), "available");
        items.put(new Movie("The Man in the High Castle", "8.1", "Frank Spotnitz","2016"), "available");
        items.put(new Movie("Silicon Valley", "8.5","Jim Kleverweis","2014"), "available");
    }

    public ArrayList<HashMap<String, String>> availableItems() {
        ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
        for (Item item : this.items.keySet())
            if (this.items.get(item).equals("available")) items.add(item.details());
        return items;
    }

    boolean isAvailable(String title) {
        for (Item item : items.keySet()) {
            if (items.get(item).equals("available") && item.titleMatches(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkoutItem(String title) {
        return updateStatus(title, "unavailable");
    }

    public boolean returnItem(String title) { return updateStatus(title, "available");}

    private boolean updateStatus(String title, String status) {
        for (Item item : items.keySet()) {
            boolean titleMatched = item.titleMatches(title);
            if(titleMatched && !items.get(item).equals(status)) {
                items.put(item, status);
                return true;
            }
        }
        return false;
    }
}
