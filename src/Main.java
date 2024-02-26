import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Library library;

    public Main() {
        this.library = new Library();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Display all books");
            System.out.println("4. Display books by genre");
            System.out.println("5. Display books by year");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    displayBooksByGenre(scanner);
                    break;
                case 5:
                    displayBooksByYear(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter year of publication: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(title, author, genre, year);
        library.addPublication(book);
        System.out.println("Book '" + title + "' added to the library.");
    }

    private void removeBook(Scanner scanner) {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        List<Publication> publications = library.getPublications();
        for (Publication publication : publications) {
            if (publication instanceof Book && publication.getTitle().equalsIgnoreCase(title)) {
                library.removePublication(publication);
                System.out.println("Book '" + title + "' removed from the library.");
                return;
            }
        }
        System.out.println("Book '" + title + "' not found in the library.");
    }

    private void displayAllBooks() {
        List<Publication> publications = library.getPublications();
        System.out.println("\nAll books in the library:");
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                Book book = (Book) publication;
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Genre: " + book.getGenre() + ", Year: " + book.getYear());
            }
        }
    }

    private void displayBooksByGenre(Scanner scanner) {
        System.out.print("Enter genre to display books: ");
        String genre = scanner.nextLine();
        List<Publication> booksByGenre = library.getPublicationsByGenre(genre);
        System.out.println("\nBooks in the '" + genre + "' genre:");
        if (booksByGenre.isEmpty()) {
            System.out.println("No books found in this genre.");
        } else {
            for (Publication publication : booksByGenre) {
                Book book = (Book) publication;
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Year: " + book.getYear());
            }
        }
    }

    private void displayBooksByYear(Scanner scanner) {
        System.out.print("Enter year to display books: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        List<Publication> booksByYear = library.getPublicationsByYear(year);
        System.out.println("\nBooks published in " + year + ":");
        if (booksByYear.isEmpty()) {
            System.out.println("No books found published in " + year + ".");
        } else {
            for (Publication publication : booksByYear) {
                Book book = (Book) publication;
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Genre: " + book.getGenre());
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}

