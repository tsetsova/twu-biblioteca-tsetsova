package com.twu.biblioteca;

class User implements Account{
    private final String libraryNumber;
    private final String password;

    User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }


}
