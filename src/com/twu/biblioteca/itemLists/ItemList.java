package com.twu.biblioteca.itemLists;

interface ItemList {
    boolean checkoutItem(String name);
    boolean returnItem(String bookName);
}
