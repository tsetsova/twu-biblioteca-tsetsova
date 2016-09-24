package com.twu.biblioteca;

public class App {

    private Console console;
    private Input input;
    private BookList bookList;
    private MovieList movieList;

    public static void main(String[] args) {
        new App(new RealConsole(), new UserInput(), new BookList(), new MovieList()).run();
    }

    App(Console console, Input input, BookList bookList, MovieList movieList) {
        this.console = console;
        this.input = input;
        this.bookList = bookList;
        this.movieList = movieList;
    }

    void run() {
        Biblioteca biblioteca = new Biblioteca(console, input, bookList, movieList);
        biblioteca.greet();
        biblioteca.menu();

        while(true) {
            String command = input.read();
            biblioteca.chooseOption(command);
            if (command.equals(Commands.quit.name)) {break;}
        }

    }
}
