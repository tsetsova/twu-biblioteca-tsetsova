package com.twu.biblioteca;

interface ItemList {
    boolean isAvailable(String name);
    void checkout(String name);
}
