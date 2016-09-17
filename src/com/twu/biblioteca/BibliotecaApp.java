package com.twu.biblioteca;

public class BibliotecaApp{

    private final Console console;

    BibliotecaApp(Console console) {
        this.console = console;
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp(new RealConsole());
        biblioteca.greet();
        biblioteca.list();
    }

    void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }

    void list() {
        console.printToScreen("The Well-Grounded Rubyist | David A. Black | 2009\n" +
                "Clean Code | Robert Cecil Martin | 2008\n" +
                "The Software Crafstman | Sandro Mancuso | 2014");
    }
}
