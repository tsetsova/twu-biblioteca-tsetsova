package com.twu.biblioteca.UserIOTests;

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
