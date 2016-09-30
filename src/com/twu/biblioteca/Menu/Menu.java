package com.twu.biblioteca.Menu;

import com.sun.deploy.util.StringUtils;
import com.twu.biblioteca.UserIO.Console;
import com.twu.biblioteca.UserIO.Input;
import com.twu.biblioteca.itemLists.ItemList;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private final Console console;
    private final Input input;
    private final ItemList itemList;

    public Menu(Console console, Input input, ItemList itemList) {
        this.console = console;
        this.input = input;
        this.itemList = itemList;
    }

    public void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }

    public void menu() {
        console.printToScreen("Menu:");
        for(Commands command : Commands.values()) {
            console.printToScreen(command.toString());
        }
        console.printToScreen("Write the number of the option you want displayed.");
    }

    public void chooseOption(String command) {
        switch (command) {
            case "List Books":
                listItems("book");
                break;
            case "List Movies":
                listItems("movie");
                break;
            case "Checkout Book":
                checkOutItem("book");
                break;
            case "Checkout Movie":
                checkOutItem("movie");
                break;
            case "Return Book":
                returnItem("book");
                break;
            case "Return Movie":
                returnItem("movie");
                break;
            case "Quit":
                quit();
                break;
            default: displayErrorMessage();
        }
    }

    private void displayErrorMessage() {
        console.printToScreen("Please choose a valid menu option!");
        menu();
    }

    private void quit() {
        console.printToScreen("Goodbye!");
    }

    private void listItems(String type) {
        for(HashMap<String, String> item : itemList.availableItems(type)) {
            ArrayList<String> details = new ArrayList<>();
            for (String key : item.keySet()) {
                details.add(item.get(key));
            }
            printAvailableItems(details);
        }
    }

    private void printAvailableItems(ArrayList<String> details) {
        console.printToScreen(StringUtils.join(details, " | "));
    }


    private void checkOutItem(String type) {
        console.printToScreen("Welcome to checkout. Which title would you like to checkout?");
        String title = input.read();
        if (itemList.checkoutItem(title, type))
            console.printToScreen("Thank you! Enjoy!");
        else
            console.printToScreen("That title is not available.");
    }


    private void returnItem(String type) {
        console.printToScreen("Welcome to returns. Which title would you like to return?");
        String title = input.read();
        if (itemList.returnItem(title, type)) {
            console.printToScreen("Thank you!");
        } else {
            console.printToScreen("That title is not available.");
        }
    }


}
