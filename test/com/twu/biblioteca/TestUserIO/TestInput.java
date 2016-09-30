package com.twu.biblioteca.TestUserIO;

import com.twu.biblioteca.UserIO.Input;

import java.util.LinkedList;

public class TestInput implements Input {
    private LinkedList<String> commands = new LinkedList<>();

    public void addCommand(String command) {
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
