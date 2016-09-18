package com.twu.biblioteca;

class Biblioteca {

    private final Console console;

    Biblioteca(Console console) {
        this.console = console;
    }

    void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }

    void menu() {
        console.printToScreen("Menu:");
        for(Commands command : Commands.values()) {
            console.printToScreen(command.menuOption.toString());
        }
        console.printToScreen("Write the number of the option you want displayed.");
    }

    void chooseOption(String command) {
        if (command.equals(Commands.list.name)) {
            list();
        } else if (command.equals(Commands.quit.name)) {
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
