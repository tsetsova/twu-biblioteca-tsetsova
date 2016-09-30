package com.twu.biblioteca.Menu;

public enum Commands {
    LIST_BOOKS("List Books"),
    LIST_MOVIES("List Movies"),
    CHECKOUT_BOOK("Checkout Book"),
    CHECKOUT_MOVIE("Checkout Movie"),
    RETURN_BOOK("Return Book"),
    RETURN_MOVIE("Return Movie"),
    QUIT("Quit");

    private final String command;

    Commands(String string) {
        command = string;
    }

    public boolean equalsName(String otherName) {
        return otherName != null && command.equals(otherName);
    }

    public String toString() {
        return this.command;
    }
}
