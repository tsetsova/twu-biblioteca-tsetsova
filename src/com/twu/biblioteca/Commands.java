package com.twu.biblioteca;

enum Commands {
    LIST(new MenuOption("1", "List books")), QUIT(new MenuOption("2", "Quit"));

    static MenuOption quit = QUIT.menuOption;
    static MenuOption list = LIST.menuOption;
    final MenuOption menuOption;

    Commands(MenuOption menuOption) {
        this.menuOption = menuOption;
    }

}
