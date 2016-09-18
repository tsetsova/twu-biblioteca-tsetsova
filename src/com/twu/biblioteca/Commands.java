package com.twu.biblioteca;

enum Commands {
    LIST(new MenuOption("1", "List books")), CHECKOUT(new MenuOption("2", "Checkout a book")), QUIT(new MenuOption("3", "Quit"));

    static MenuOption quit = QUIT.menuOption;
    static MenuOption checkout = CHECKOUT.menuOption;
    static MenuOption list = LIST.menuOption;
    final MenuOption menuOption;

    Commands(MenuOption menuOption) {
        this.menuOption = menuOption;
    }

}
