package com.twu.biblioteca.UserIO;

public class RealConsole implements Console{
    public void printToScreen(String message) {
        System.out.println(message);
    }
}