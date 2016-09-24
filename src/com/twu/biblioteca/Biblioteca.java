package com.twu.biblioteca;

class Biblioteca {

    private final Console console;
    private final Input input;
    private final BookList bookList;
    private final MovieList movieList;
    private Account account;

    Biblioteca(Console console, Input input, BookList bookList, MovieList movieList, Account account) {
        this.account = account;
        this.console = console;
        this.input = input;
        this.bookList = bookList;
        this.movieList = movieList;
    }

    void greet() {
        console.printToScreen("Welcome to Biblioteca");
    }

    void menu() {
        console.printToScreen("Menu:");
        if (account instanceof User) {
            for(MenuOption menuOption : Commands.LoggedInCommands) {
                console.printToScreen(menuOption.toString());
            }
        } else {
            for(MenuOption menuOption : Commands.SignedOutCommands) {
                console.printToScreen(menuOption.toString());
            }
        }
        console.printToScreen("Write the number of the option you want displayed.");
    }

    void chooseOption(String command) {
        if (command.equals(Commands.listBooks.name)) {
            listBooks();
        } else if (command.equals(Commands.listMovies.name)) {
            listMovies();
        } else if (command.equals(Commands.login.name)) {
            logIn();
        } else if (command.equals(Commands.quit.name)) {
            console.printToScreen("Goodbye!");
        } else if (command.equals(Commands.checkoutBook.name)) {
            checkOutBook();
        } else if (command.equals(Commands.checkoutMovie.name)) {
            checkOutMovie();
        } else if (command.equals(Commands.returnBook.name)) {
            returnBook();
        } else {
            console.printToScreen("Please choose a valid menu option!");
            menu();
        }
    }

    private void logIn() {
        console.printToScreen("Welcome to Login. Please fill in your library number." );
        String libraryNumber = input.read();
        console.printToScreen("Thanks, and your password, please.");
        String password = input.read();
        console.printToScreen("Lovely, now you can checkout books and movies.");
        account = new User(libraryNumber, password);
        menu();
    }

    private void listBooks() {

        for (Book book : bookList.allBooks()) {
            console.printToScreen(book.toString());
        }
    }

    private void listMovies() {
        for (Movie movie : movieList.allMovies()) {
            console.printToScreen(movie.toString());
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

    private void checkOutMovie() {
        console.printToScreen("Welcome to checkout. Which movie title would you like to checkout?");
        String movieName = input.read();
        if (movieList.isMovieAvailable(movieName)) {
            movieList.checkout(movieName);
            console.printToScreen("Thank you! Enjoy the movie!");
        } else
            console.printToScreen("That movie is not available.");
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


}
