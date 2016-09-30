package com.twu.biblioteca.UserIO;

import java.util.Scanner;

public class UserInput implements Input{
    private final Scanner reader = new Scanner(System.in);
    public String read(){
        return reader.nextLine().replace("\\n", "");
    }
}
