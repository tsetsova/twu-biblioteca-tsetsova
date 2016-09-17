package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BibliotecaAppTest {

    private TestConsole console = new TestConsole();
    private TestInput input = new TestInput();
    private BibliotecaApp biblioteca = new BibliotecaApp(console, input);

    @Test
    public void DisplaysAGreetingMessage() {
        biblioteca.greet();
        assertEquals("Welcome to Biblioteca", console.printed());
    }

    @Test
    public void DisplaysAMenu() {
        biblioteca.menu();
        assertEquals("Menu:\n " +
                     "1: List books\n" +
                     "Write the number of the option you want displayed.", console.printed());
    }

    @Test
    public void CanChooseAnOptionFromAMenu() {
        input.setMessage("1");
        biblioteca.chooseOption();

        assertEquals("The Well-Grounded Rubyist | David A. Black | 2009\n" +
                "Clean Code | Robert Cecil Martin | 2008\n" +
                "The Software Crafstman | Sandro Mancuso | 2014", console.printed());
    }


    private class TestConsole implements Console {
        private String printed = "";

        public void printToScreen(String message) {
            printed += message;
        }

        String printed() {
            return printed;
        }
    }

    private class TestInput implements Input {
        private String message;

        void setMessage(String message) {
            this.message = message;
        }

        public String read() {
            return message;
        }
    }
}
