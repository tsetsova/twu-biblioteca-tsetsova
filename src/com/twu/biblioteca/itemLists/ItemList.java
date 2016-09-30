package com.twu.biblioteca.itemLists;
import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ItemList implements ItemListInterface {

    private LinkedHashMap<Item, String> items = new LinkedHashMap<Item, String>();

    ItemList(LinkedHashMap<Item, String> items) {
        this.items = items;
    }

    public ItemList() {
        items.put(new Book("The Well-Grounded Rubyist", "David A. Black", "2009"), "available");
        items.put(new Book("Clean Code", "Robert Cecil Martin", "2008"), "available");
        items.put(new Book("The Software Crafstman", "Sandro Mancuso", "2014"), "available");
    }

    public ArrayList<HashMap<String, String>> availableItems() {
        ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
        for (Item item : this.items.keySet())
            if (this.items.get(item).equals("available")) items.add(item.details());
        return items;
    }

    boolean isAvailable(String title) {
        for (Item item : items.keySet()) {
            if (items.get(item).equals("available") && item.titleMatches(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkoutItem(String title) {
        return updateStatus(title, "unavailable");
    }

    public boolean returnItem(String title) { return updateStatus(title, "available");}

    private boolean updateStatus(String title, String status) {
        for (Item item : items.keySet()) {
            boolean titleMatched = item.titleMatches(title);
            if(titleMatched && !items.get(item).equals(status)) {
                items.put(item, status);
                return true;
            }
        }
        return false;
    }
}