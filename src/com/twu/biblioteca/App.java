package com.twu.biblioteca;

public class App {


    private Console console;
    private Input input;

    public static void main(String[] args) {
        new App(new RealConsole(), new UserInput()).run();
    }

    App(Console console, Input input) {
        this.console = console;
        this.input = input;
    }

    void run() {
        Biblioteca biblioteca = new Biblioteca(console, input);
        biblioteca.greet();
        biblioteca.menu();
        biblioteca.chooseOption();
    }
}