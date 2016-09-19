package com.twu.biblioteca;

enum Commands {
    LIST_BOOKS(new MenuOption("1", "List books")), LIST_MOVIES(new MenuOption("2", "List movies")), CHECKOUT(new MenuOption("3", "Checkout a book")),
            CHECKOUT_MOVIE(new MenuOption("4", "Checkout a movie")), RETURN_BOOK(new MenuOption("5", "Return Book")), QUIT(new MenuOption("6", "Quit"));

    static MenuOption quit = QUIT.menuOption;
    static MenuOption checkoutBook = CHECKOUT.menuOption;
    static MenuOption listBooks = LIST_BOOKS.menuOption;
    static MenuOption listMovies = LIST_MOVIES.menuOption;
    static MenuOption returnBook = RETURN_BOOK.menuOption;
    static MenuOption checkoutMovie = CHECKOUT_MOVIE.menuOption;
    final MenuOption menuOption;

    Commands(MenuOption menuOption) {
        this.menuOption = menuOption;
    }

}
