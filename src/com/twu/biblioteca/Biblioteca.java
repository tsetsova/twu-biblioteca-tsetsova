package com.twu.biblioteca;

import java.util.ArrayList;

class Biblioteca {
    private class MenuOption {
        private final String description;
        private final String name;

        MenuOption(String name, String description) {
            this.name = name;
            this.description = description;
        }

        @Override
        public String toString() {
            return name + ": " + description;
        }
    }

    private final Console console;
    private final ArrayList<MenuOption> menuOptions =  new ArrayList<MenuOption>();

    Biblioteca(Console console) {
        menuOptions.add(new MenuOption("1", "List books"));
        menuOptions.add(new MenuOption("2", "Quit"));
        this.console = console;
    }

    void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }

    void menu() {
        console.printToScreen("Menu:");
        for(MenuOption menuOption : menuOptions) {
            console.printToScreen(menuOption.toString());
        }
        console.printToScreen("Write the number of the option you want displayed.");
    }

    void chooseOption(String command) {
        if (command.equals("1")) {
            list();
        } else if (command.equals("2")) {
            console.printToScreen("Goodbye! Enjoy your books.");
        } else {
            console.printToScreen("Please choose a valid menu option!");
            menu();
        }
    }

    private void list() {
        console.printToScreen("The Well-Grounded Rubyist | David A. Black | 2009\n" +
                "Clean Code | Robert Cecil Martin | 2008\n" +
                "The Software Crafstman | Sandro Mancuso | 2014");
    }
}
