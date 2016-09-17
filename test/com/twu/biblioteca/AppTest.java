package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private TestConsole console = new TestConsole();
    private TestInput input = new TestInput();

    private final App app = new App(console, input);

    @Test
    public void userCanQuit() {
        input.addCommand("2");
        app.run();
        assertEquals("Welcome to Biblioteca\n" +
                     "Menu:\n " +
                     "1: List books\n" +
                     "2: Quit\n" +
                     "Write the number of the option you want displayed.\n" +
                     "Goodbye! Enjoy your books.\n", console.printed());
    }
}
