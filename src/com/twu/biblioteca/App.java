package com.twu.biblioteca;

public class App {


    private Console console;
    private Input input;
    private BookList bookList;

    public static void main(String[] args) {
        new App(new RealConsole(), new UserInput(), new BookList()).run();
    }

    App(Console console, Input input, BookList bookList) {
        this.console = console;
        this.input = input;
        this.bookList = bookList;
    }

    void run() {
        Biblioteca biblioteca = new Biblioteca(console, input, bookList);
        biblioteca.greet();
        biblioteca.menu();

        while(true) {
            String command = input.read();
            biblioteca.chooseOption(command);
            if (command.equals(Commands.quit.name)) {break;}
        }

    }
}
