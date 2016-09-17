package com.twu.biblioteca;

public class BibliotecaApp{

    private final Console console;
    private Input input;

    BibliotecaApp(Console console, Input input) {
        this.console = console;
        this.input = input;
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp(new RealConsole(), new UserInput());
        biblioteca.greet();
        biblioteca.menu();
        biblioteca.chooseOption();
    }

    void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }

    void menu() {
        console.printToScreen("Menu:\n " +
                "1: List books\n" +
                "Write the number of the option you want displayed.");
    }

    void chooseOption() {
        if (input.read().equals("1")) { list(); }
    }

    private void list() {
        console.printToScreen("The Well-Grounded Rubyist | David A. Black | 2009\n" +
                "Clean Code | Robert Cecil Martin | 2008\n" +
                "The Software Crafstman | Sandro Mancuso | 2014");
    }
}
