package com.twu.biblioteca;


import com.twu.biblioteca.UserIOTests.TestConsole;
import com.twu.biblioteca.UserIOTests.TestInput;
import com.twu.biblioteca.itemLists.ItemList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MenuTest {

    private TestConsole console = new TestConsole();
    private TestInput input = new TestInput();
    private ItemList itemlist = new ItemList();
    private Menu biblioteca = new Menu(console, input, itemlist);

    @Test
    public void DisplaysAGreetingMessage() {
        biblioteca.greet();
        assertEquals("Welcome to Menu\n", console.printed());
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
        assertEquals("Welcome to checkout. Which title would you like to checkout?\n" +
                "Thank you! Enjoy!\n", console.printed() );
    }


    @Test
    public void DisplaysUnsuccesfullCheckoutMessage() {
        input.addCommand("Coding with Bob");
        biblioteca.chooseOption(Commands.checkoutBook.name);
        assertEquals("Welcome to checkout. Which title would you like to checkout?\n" +
                "That title is not available.\n", console.printed() );
    }

    @Test
    public void DisplaysSuccessfullReturnMessage(){
        input.addCommand("The Well-Grounded Rubyist");
        input.addCommand("The Well-Grounded Rubyist");
        biblioteca.chooseOption(Commands.checkoutBook.name);
        biblioteca.chooseOption(Commands.returnBook.name);
        assertEquals("Welcome to checkout. Which title would you like to checkout?\n" +
                "Thank you! Enjoy!\n" +
                "Welcome to returns. Which title would you like to return?\n" +
                "Thank you!\n", console.printed());
    }

    @Test
    public void DisplaysUnsuccessfullReturnMessageIfBookIsCheckedOut(){
        input.addCommand("The Well-Grounded Rubyist");
        biblioteca.chooseOption(Commands.returnBook.name);
        assertEquals("Welcome to returns. Which title would you like to return?\n" +
                     "That title is not available.\n", console.printed());
    }

    @Test
    public void DisplaysUnsuccessfullReturnMessageIfBookDoesntExist(){
        input.addCommand("The Well-Grounded Robot");
        biblioteca.chooseOption(Commands.returnBook.name);
        assertEquals("Welcome to returns. Which title would you like to return?\n" +
                "That title is not available.\n", console.printed());
    }

    @Test
    public void DisplaysAnExitMessageWhenUserQuits() {
        biblioteca.chooseOption(Commands.quit.name);
        assertEquals("Goodbye!\n", console.printed());
    }

}
