package com.twu.biblioteca;

import com.twu.biblioteca.UserIOTests.TestConsole;
import com.twu.biblioteca.UserIOTests.TestInput;
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
        input.addCommand(Commands.listBooks.name);
        input.addCommand(Commands.checkoutBook.name);
        input.addCommand("Clean Code");
        input.addCommand(Commands.listBooks.name);
        input.addCommand(Commands.quit.name);
        app.run();
        assertEquals("Welcome to Menu\n" +
                     "Menu:\n" +
                     Commands.listBooks.toString() + "\n" +
                     Commands.listMovies.toString() + "\n" +
                     Commands.checkoutBook.toString() + "\n" +
                     Commands.checkoutMovie.toString() + "\n" +
                     Commands.returnBook.toString() + "\n" +
                     Commands.quit.toString() + "\n" +
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
        input.addCommand(Commands.listBooks.name);
        input.addCommand(Commands.checkoutBook.name);
        input.addCommand("Clean Code");
        input.addCommand(Commands.returnBook.name);
        input.addCommand("Clean Code");
        input.addCommand(Commands.listBooks.name);
        input.addCommand(Commands.quit.name);
        app.run();
        assertEquals("Welcome to Menu\n" +
                "Menu:\n" +
                Commands.listBooks.toString() + "\n" +
                Commands.listMovies.toString() + "\n" +
                Commands.checkoutBook.toString() + "\n" +
                Commands.checkoutMovie.toString() + "\n" +
                Commands.returnBook.toString() + "\n" +
                Commands.quit.toString() + "\n" +
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
        input.addCommand(Commands.listMovies.name);
        input.addCommand(Commands.checkoutMovie.name);
        input.addCommand("Mr. Robot");
        input.addCommand(Commands.listMovies.name);
        input.addCommand(Commands.quit.name);
        app.run();
        assertEquals("Welcome to Menu\n" +
                "Menu:\n" +
                Commands.listBooks.toString() + "\n" +
                Commands.listMovies.toString() + "\n" +
                Commands.checkoutBook.toString() + "\n" +
                Commands.checkoutMovie.toString() + "\n" +
                Commands.returnBook.toString() + "\n" +
                Commands.quit.toString() + "\n" +
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
}
