package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private TestConsole console = new TestConsole();
    private BookList bookList = new BookList();
    private TestInput input = new TestInput();
    private MovieList movieList = new MovieList();
    private Biblioteca biblioteca = new Biblioteca(console, input, bookList, movieList);

    @Test
    public void DisplaysAGreetingMessage() {
        biblioteca.greet();
        assertEquals("Welcome to Biblioteca\n", console.printed());
    }

    @Test
    public void DisplaysAMenu() {
        biblioteca.menu();
        assertEquals("Menu:\n" +
                     Commands.listBooks.toString() + "\n" +
                     Commands.listMovies.toString() + "\n" +
                     Commands.checkoutBook.toString() + "\n" +
                     Commands.checkoutMovie.toString() + "\n" +
                     Commands.returnBook.toString() + "\n" +
                     Commands.quit.toString() + "\n" +
                     "Write the number of the option you want displayed.\n", console.printed());
    }

    @Test
    public void ListsBooks() {
        biblioteca.chooseOption(Commands.listBooks.name);

        assertEquals("The Well-Grounded Rubyist | David A. Black | 2009\n" +
                "Clean Code | Robert Cecil Martin | 2008\n" +
                "The Software Crafstman | Sandro Mancuso | 2014\n", console.printed());
    }

    @Test
    public void ListsMovies() {
        biblioteca.chooseOption(Commands.listMovies.name);

        assertEquals("Mr. Robot | 8.7 | Sam Esmail | 2015\n" +
                     "The Man in the High Castle | 8.1 | Frank Spotnitz | 2016\n" +
                     "Silicon Valley | 8.5 | Jim Kleverweis | 2014\n", console.printed());
    }

    @Test
    public void ReturnsAnErrorMessageIfMenuOptionIsInvalid() {
        biblioteca.chooseOption("Invalid");

        assertEquals("Please choose a valid menu option!\n" +
                     "Menu:\n" +
                     Commands.listBooks.toString() + "\n" +
                     Commands.listMovies.toString() + "\n" +
                     Commands.checkoutBook.toString() + "\n" +
                     Commands.checkoutMovie.toString() + "\n" +
                     Commands.returnBook.toString() + "\n" +
                     Commands.quit.toString() + "\n" +
                     "Write the number of the option you want displayed.\n", console.printed());
    }

    @Test
    public void DisplaysSuccesfullCheckoutMessage() {
        input.addCommand("The Well-Grounded Rubyist");
        biblioteca.chooseOption(Commands.checkoutBook.name);
        assertEquals("Welcome to checkout. Which book title would you like to checkout?\n" +
                "Thank you! Enjoy the book!\n", console.printed() );
    }


    @Test
    public void DisplaysUnsuccesfullCheckoutMessage() {
        input.addCommand("Coding with Bob");
        biblioteca.chooseOption(Commands.checkoutBook.name);
        assertEquals("Welcome to checkout. Which book title would you like to checkout?\n" +
                "That book is not available.\n", console.printed() );
    }

    @Test
    public void DisplaysSuccessfullReturnMessage(){
        input.addCommand("The Well-Grounded Rubyist");
        input.addCommand("The Well-Grounded Rubyist");
        biblioteca.chooseOption(Commands.checkoutBook.name);
        biblioteca.chooseOption(Commands.returnBook.name);
        assertEquals("Welcome to checkout. Which book title would you like to checkout?\n" +
                "Thank you! Enjoy the book!\n" +
                "Welcome to returns. Which book would you like to return?\n" +
                "Thank you for returning the book\n", console.printed());
    }

    @Test
    public void DisplaysUnsuccessfullReturnMessage(){
        input.addCommand("The Well-Grounded Rubyist");
        biblioteca.chooseOption(Commands.returnBook.name);
        assertEquals("Welcome to returns. Which book would you like to return?\n" +
                "That is not a valid book to return.\n", console.printed());
    }

    @Test
    public void DisplaysAnExitMessageWhenUserQuits() {
        biblioteca.chooseOption(Commands.quit.name);

        assertEquals("Goodbye!\n", console.printed());
    }

}
