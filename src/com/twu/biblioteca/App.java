package com.twu.biblioteca;

import com.twu.biblioteca.UserIO.Console;
import com.twu.biblioteca.UserIO.Input;
import com.twu.biblioteca.UserIO.RealConsole;
import com.twu.biblioteca.UserIO.UserInput;
import com.twu.biblioteca.itemLists.ItemList;
import com.twu.biblioteca.itemLists.MovieList;

public class App {


    private Console console;
    private Input input;
    private ItemList bookList;
    private MovieList movieList;

    public static void main(String[] args) {
        new App(new RealConsole(), new UserInput(), new ItemList(), new MovieList()).run();
    }

    App(Console console, Input input, ItemList bookList, MovieList movieList) {
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
