package com.twu.biblioteca.TestUserIO;

import com.twu.biblioteca.UserIO.Console;

public class TestConsole implements Console {
    private String printed = "";

    public void printToScreen(String message) {
        printed += message + "\n";
    }

    public String printed() {
        return printed;
    }
}
