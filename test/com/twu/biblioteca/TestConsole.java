package com.twu.biblioteca;

class TestConsole implements Console {
    private String printed = "";

    public void printToScreen(String message) {
        printed += message + "\n";
    }

    String printed() {
        return printed;
    }
}
