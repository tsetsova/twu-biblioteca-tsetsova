package com.twu.biblioteca;

class Biblioteca {

    private final Console console;
    private Input input;

    Biblioteca(Console console, Input input) {
        this.console = console;
        this.input = input;
    }

    void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }

    void menu() {
        console.printToScreen("Menu:\n" +
                              "1: List books\n" +
                              "2: Quit\n" +
                              "Write the number of the option you want displayed.");
    }

    void chooseOption() {
        String command = input.read();
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
