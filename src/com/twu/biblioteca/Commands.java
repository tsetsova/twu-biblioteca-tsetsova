package com.twu.biblioteca;

enum Commands {
    LIST_BOOKS(new MenuOption("1", "List books")), LIST_MOVIES(new MenuOption("2", "List movies")), CHECKOUT(new MenuOption("3", "Checkout a book")),
    RETURN_BOOK(new MenuOption("4", "Return Book")), QUIT(new MenuOption("5", "Quit"));

    static MenuOption quit = QUIT.menuOption;
    static MenuOption checkout = CHECKOUT.menuOption;
    static MenuOption listBooks = LIST_BOOKS.menuOption;
    static MenuOption listMovies = LIST_MOVIES.menuOption;
    static MenuOption returnBook = RETURN_BOOK.menuOption;
    final MenuOption menuOption;

    Commands(MenuOption menuOption) {
        this.menuOption = menuOption;
    }

}
