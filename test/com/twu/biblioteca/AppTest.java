package com.twu.biblioteca;

import com.twu.biblioteca.Menu.Commands;
import com.twu.biblioteca.TestUserIO.TestConsole;
import com.twu.biblioteca.TestUserIO.TestInput;
import com.twu.biblioteca.itemLists.ItemList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private TestConsole console = new TestConsole();
    private TestInput input = new TestInput();
    private ItemList itemList = new ItemList();

    private final App app = new App(console, input, itemList);

    @Test
    public void userCanCheckoutABook() {
        input.addCommand(Commands.LIST_BOOKS.toString());
        input.addCommand(Commands.CHECKOUT_BOOK.toString());
        input.addCommand("Clean Code");
        input.addCommand(Commands.LIST_BOOKS.toString());
        input.addCommand(Commands.QUIT.toString());
        app.run();
        assertEquals("Welcome to Biblioteca\n" +
                     menu() +
                     "Write the number of the option you want displayed.\n" +
                     "The Well-Grounded Rubyist | David A. Black | 2009\n" +
                     "Clean Code | Robert Cecil Martin | 2008\n" +
                     "The Software Crafstman | Sandro Mancuso | 2014\n" +
                     "Welcome to checkout. Which title would you like to checkout?\n" +
                     "Thank you! Enjoy!\n" +
                     "The Well-Grounded Rubyist | David A. Black | 2009\n" +
                     "The Software Crafstman | Sandro Mancuso | 2014\n" +
                     "Goodbye!\n", console.printed());
    }

    @Test
    public void userCanReturnABook() {
        input.addCommand(Commands.LIST_BOOKS.toString());
        input.addCommand(Commands.CHECKOUT_BOOK.toString());
        input.addCommand("Clean Code");
        input.addCommand(Commands.RETURN_BOOK.toString());
        input.addCommand("Clean Code");
        input.addCommand(Commands.LIST_BOOKS.toString());
        input.addCommand(Commands.QUIT.toString());
        app.run();
        assertEquals("Welcome to Biblioteca\n" +
                    menu() +
                    "Write the number of the option you want displayed.\n" +
                    "The Well-Grounded Rubyist | David A. Black | 2009\n" +
                    "Clean Code | Robert Cecil Martin | 2008\n" +
                    "The Software Crafstman | Sandro Mancuso | 2014\n" +
                    "Welcome to checkout. Which title would you like to checkout?\n" +
                    "Thank you! Enjoy!\n" +
                    "Welcome to returns. Which title would you like to return?\n" +
                    "Thank you!\n" +
                    "The Well-Grounded Rubyist | David A. Black | 2009\n" +
                    "Clean Code | Robert Cecil Martin | 2008\n" +
                    "The Software Crafstman | Sandro Mancuso | 2014\n" +
                    "Goodbye!\n", console.printed());
    }

    @Test
    public void userCanCheckoutAMovie() {
        input.addCommand(Commands.LIST_MOVIES.toString());
        input.addCommand(Commands.CHECKOUT_MOVIE.toString());
        input.addCommand("Mr. Robot");
        input.addCommand(Commands.LIST_MOVIES.toString());
        input.addCommand(Commands.QUIT.toString());
        app.run();
        assertEquals("Welcome to Biblioteca\n" +
                    menu() +
                    "Write the number of the option you want displayed.\n" +
                    "Mr. Robot | 8.7 | Sam Esmail | 2015\n" +
                    "The Man in the High Castle | 8.1 | Frank Spotnitz | 2016\n" +
                    "Silicon Valley | 8.5 | Jim Kleverweis | 2014\n" +
                    "Welcome to checkout. Which title would you like to checkout?\n" +
                    "Thank you! Enjoy!\n" +
                    "The Man in the High Castle | 8.1 | Frank Spotnitz | 2016\n" +
                    "Silicon Valley | 8.5 | Jim Kleverweis | 2014\n" +
                    "Goodbye!\n", console.printed());
    }

    @Test
    public void userCanReturnAMovie() {
        input.addCommand(Commands.LIST_MOVIES.toString());
        input.addCommand(Commands.CHECKOUT_MOVIE.toString());
        input.addCommand("Mr. Robot");
        input.addCommand(Commands.RETURN_MOVIE.toString());
        input.addCommand("Mr. Robot");
        input.addCommand(Commands.LIST_MOVIES.toString());
        input.addCommand(Commands.QUIT.toString());
        app.run();
        assertEquals("Welcome to Biblioteca\n" +
                menu() +
                "Write the number of the option you want displayed.\n" +
                "Mr. Robot | 8.7 | Sam Esmail | 2015\n" +
                "The Man in the High Castle | 8.1 | Frank Spotnitz | 2016\n" +
                "Silicon Valley | 8.5 | Jim Kleverweis | 2014\n" +
                "Welcome to checkout. Which title would you like to checkout?\n" +
                "Thank you! Enjoy!\n" +
                "Welcome to returns. Which title would you like to return?\n" +
                "Thank you!\n" +
                "Mr. Robot | 8.7 | Sam Esmail | 2015\n" +
                "The Man in the High Castle | 8.1 | Frank Spotnitz | 2016\n" +
                "Silicon Valley | 8.5 | Jim Kleverweis | 2014\n" +
                "Goodbye!\n", console.printed());
    }

    private String menu() {
        return "Menu:\n" +
                Commands.LIST_BOOKS.toString() + "\n" +
                Commands.LIST_MOVIES.toString() + "\n" +
                Commands.CHECKOUT_BOOK.toString() + "\n" +
                Commands.CHECKOUT_MOVIE.toString() + "\n" +
                Commands.RETURN_BOOK.toString() + "\n" +
                Commands.RETURN_MOVIE.toString() + "\n" +
                Commands.QUIT.toString() + "\n";
    }
}
