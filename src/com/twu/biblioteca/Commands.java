package com.twu.biblioteca;

enum Commands {
    LIST(new MenuOption("1", "List books")), CHECKOUT(new MenuOption("2", "Checkout a book")),
    RETURN_BOOK(new MenuOption("3", "Return Book")), QUIT(new MenuOption("4", "Quit"));

    static MenuOption quit = QUIT.menuOption;
    static MenuOption checkout = CHECKOUT.menuOption;
    static MenuOption list = LIST.menuOption;
    static MenuOption returnBook = RETURN_BOOK.menuOption;
    final MenuOption menuOption;

    Commands(MenuOption menuOption) {
        this.menuOption = menuOption;
    }

}
