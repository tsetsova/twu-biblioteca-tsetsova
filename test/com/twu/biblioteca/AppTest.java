package com.twu.biblioteca;

import com.twu.biblioteca.itemLists.BookList;
import com.twu.biblioteca.itemLists.MovieList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private TestConsole console = new TestConsole();
    private TestInput input = new TestInput();
    private BookList bookList = new BookList();
    private MovieList movieList = new MovieList();

    private final App app = new App(console, input, bookList, movieList);

    @Test
    public void userCanCheckoutABook() {
        input.addCommand(Commands.listBooks.name);
        input.addCommand(Commands.checkoutBook.name);
        input.addCommand("Clean Code");
        input.addCommand(Commands.listBooks.name);
        input.addCommand(Commands.quit.name);
        app.run();
        assertEquals("Welcome to Biblioteca\n" +
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
                     "Welcome to checkout. Which book title would you like to checkout?\n" +
                     "Thank you! Enjoy the book!\n" +
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
        assertEquals("Welcome to Biblioteca\n" +
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
                "Welcome to checkout. Which book title would you like to checkout?\n" +
                "Thank you! Enjoy the book!\n" +
                "Welcome to returns. Which book would you like to return?\n" +
                "Thank you for returning the book\n" +
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
        assertEquals("Welcome to Biblioteca\n" +
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
                "Welcome to checkout. Which movie title would you like to checkout?\n" +
                "Thank you! Enjoy the movie!\n" +
                "The Man in the High Castle | 8.1 | Frank Spotnitz | 2016\n" +
                "Silicon Valley | 8.5 | Jim Kleverweis | 2014\n" +
                "Goodbye!\n", console.printed());
    }
}
