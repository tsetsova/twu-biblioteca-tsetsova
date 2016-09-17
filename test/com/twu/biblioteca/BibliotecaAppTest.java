package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BibliotecaAppTest {

    private TestConsole console = new TestConsole();
    private BibliotecaApp biblioteca = new BibliotecaApp(console);

    @Test
    public void DisplaysAGreetingMessage() {
        biblioteca.greet();
        assertEquals("Welcome to Biblioteca", console.printed);
    }


    private class TestConsole implements Console{
        private String printed = "";
        public void printToScreen(String message) {
            printed += message;
        }
        public String printed() {
            return printed;
        }
    }
}
