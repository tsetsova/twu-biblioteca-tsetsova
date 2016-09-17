package com.twu.biblioteca;

public class BibliotecaApp{

    private final Console console;

    BibliotecaApp(Console console) {
        this.console = console;
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp(new RealConsole());
        biblioteca.greet();
    }

    void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }
}
