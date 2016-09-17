package com.twu.biblioteca;

class RealConsole implements Console{
    public void printToScreen(String message) {
        System.out.println(message);
    }
}