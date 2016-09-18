package com.twu.biblioteca;

class MenuOption {
    private final String description;
    final String name;

    MenuOption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
