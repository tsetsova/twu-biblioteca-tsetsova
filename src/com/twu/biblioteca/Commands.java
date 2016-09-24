package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

enum Commands {
    QUIT(new MenuOption("0", "Quit")), LIST_BOOKS(new MenuOption("1", "List books")), LIST_MOVIES(new MenuOption("2", "List movies")), CHECKOUT_BOOK(new MenuOption("3", "Checkout a book")),
    CHECKOUT_MOVIE(new MenuOption("4", "Checkout a movie")), RETURN_BOOK(new MenuOption("5", "Return Book")), LOGIN(new MenuOption("6", "Login"));

    static MenuOption listBooks = LIST_BOOKS.menuOption;
    static MenuOption listMovies = LIST_MOVIES.menuOption;
    static MenuOption login = LOGIN.menuOption;
    static MenuOption checkoutBook = CHECKOUT_BOOK.menuOption;
    static MenuOption checkoutMovie = CHECKOUT_MOVIE.menuOption;
    static MenuOption returnBook = RETURN_BOOK.menuOption;
    static MenuOption quit = QUIT.menuOption;
    final MenuOption menuOption;

    Commands(MenuOption menuOption) {
        this.menuOption = menuOption;
    }

    static ArrayList<MenuOption> SignedOutCommands = new ArrayList <MenuOption>(Arrays.asList(listBooks, listMovies, login, quit));
    static ArrayList<MenuOption> LoggedInCommands = new ArrayList <MenuOption>(Arrays.asList(listBooks, listMovies, checkoutBook, checkoutMovie, returnBook, quit));

}
