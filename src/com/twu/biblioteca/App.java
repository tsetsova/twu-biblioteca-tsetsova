package com.twu.biblioteca;

import com.twu.biblioteca.Menu.Commands;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.UserIO.Console;
import com.twu.biblioteca.UserIO.Input;
import com.twu.biblioteca.UserIO.RealConsole;
import com.twu.biblioteca.UserIO.UserInput;
import com.twu.biblioteca.itemLists.ItemList;

public class App {


    private Console console;
    private Input input;
    private ItemList itemList;

    public static void main(String[] args) {
        new App(new RealConsole(), new UserInput(), new ItemList()).run();
    }

    App(Console console, Input input, ItemList itemList) {
        this.console = console;
        this.input = input;
        this.itemList = itemList;
    }

    void run() {
        Menu biblioteca = new Menu(console, input, itemList);
        biblioteca.greet();
        biblioteca.menu();

        while(true) {
            String command = input.read();
            biblioteca.chooseOption(command);
            if (command.equals(Commands.QUIT.toString())) {break;}
        }

    }
}
