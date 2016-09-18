package com.twu.biblioteca;

class Biblioteca {

    private final Console console;
    private final Input input;
    private final BookList bookList;

    Biblioteca(Console console, Input input, BookList bookList) {
        this.console = console;
        this.input = input;
        this.bookList = bookList;
    }

    void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }

    void menu() {
        console.printToScreen("Menu:");
        for(Commands command : Commands.values()) {
            console.printToScreen(command.menuOption.toString());
        }
        console.printToScreen("Write the number of the option you want displayed.");
    }

    void chooseOption(String command) {
        if (command.equals(Commands.list.name)) {
            list();
        } else if (command.equals(Commands.quit.name)) {
            console.printToScreen("Goodbye!");
        } else if (command.equals(Commands.checkout.name)) {
            checkOutBook();
        } else if (command.equals(Commands.returnBook.name)) {
            returnBook();
        } else {
            console.printToScreen("Please choose a valid menu option!");
            menu();
        }
    }

    private void returnBook() {
        console.printToScreen("Welcome to returns. Which book would you like to return?");
        String bookName = input.read();
        if (bookList.isBookCheckedOut(bookName)) {
            bookList.returnBook(bookName);
            console.printToScreen("Thank you for returning the book");
        } else {
            console.printToScreen("That is not a valid book to return.");
        }
    }

    private void checkOutBook() {
        console.printToScreen("Welcome to checkout. Which book title would you like to checkout?");
        String bookName = input.read();
        if (bookList.isBookAvailable(bookName)) {
            bookList.checkout(bookName);
            console.printToScreen("Thank you! Enjoy the book!");
        } else
            console.printToScreen("That book is not available.");
    }

    private void list() {

        for (Book book : bookList.allBooks()) {
            console.printToScreen(book.toString());
        }
    }
}
