package com.twu.biblioteca;

import java.util.Scanner;

class UserInput implements Input{
    private final Scanner reader = new Scanner(System.in);
    public String read(){
        return reader.nextLine().replace("\\n", "");
    }
}
