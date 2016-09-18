package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private TestConsole console = new TestConsole();
    private BookList bookList = new BookList();
    private TestInput input = new TestInput();
    private Biblioteca biblioteca = new Biblioteca(console, input, bookList);

    @Test
    public void DisplaysAGreetingMessage() {
        biblioteca.greet();
        assertEquals("Welcome to Biblioteca\n", console.printed());
    }

    @Test
    public void DisplaysAMenu() {
        biblioteca.menu();
        assertEquals("Menu:\n" +
                     Commands.list.toString() + "\n" +
                     Commands.checkout.toString() + "\n" +
                     Commands.quit.toString() + "\n" +
                     "Write the number of the option you want displayed.\n", console.printed());
    }

    @Test
    public void CanChooseAnOptionFromAMenu() {
        biblioteca.chooseOption(Commands.list.name);

        assertEquals("The Well-Grounded Rubyist | David A. Black | 2009\n" +
                "Clean Code | Robert Cecil Martin | 2008\n" +
                "The Software Crafstman | Sandro Mancuso | 2014\n", console.printed());
    }

    @Test
    public void ReturnsAnErrorMessageIfMenuOptionIsInvalid() {
        biblioteca.chooseOption("Invalid");

        assertEquals("Please choose a valid menu option!\n" +
                     "Menu:\n" +
                     Commands.list.toString() + "\n" +
                     Commands.checkout.toString() + "\n" +
                     Commands.quit.toString() + "\n" +
                     "Write the number of the option you want displayed.\n", console.printed());
    }

    @Test
    public void DisplaysAnExitMessageWhenUserQuits() {
        biblioteca.chooseOption(Commands.quit.name);

        assertEquals("Goodbye!\n", console.printed());
    }

    @Test
    public void DisplaysSuccesfullCheckoutMessage() {
        input.addCommand("The Well-Grounded Rubyist");
        biblioteca.chooseOption(Commands.checkout.name);
        assertEquals("Welcome to checkout. Which book title would you like to checkout?\n" +
                     "Thank you! Enjoy the book!\n", console.printed() );
    }


    @Test
    public void DisplaysUnsuccesfullCheckoutMessage() {
        input.addCommand("Coding with Bob");
        biblioteca.chooseOption(Commands.checkout.name);
        assertEquals("Welcome to checkout. Which book title would you like to checkout?\n" +
                "That book is not available.\n", console.printed() );
    }
}
