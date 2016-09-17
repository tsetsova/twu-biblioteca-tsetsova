package com.twu.biblioteca;

import java.util.LinkedList;

class TestInput implements Input {
    private LinkedList<String> commands = new LinkedList<String>();

    void addCommand(String command) {
        this.commands.add(command);
    }

    public String read() {
        try {
            return this.commands.remove();
        } catch (RuntimeException exception) {
            throw new RuntimeException("Must provide enough commands for the reader");
        }
    }
}
