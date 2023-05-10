package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

class BookInfo {
    int id;
    String title;
    String author;
    boolean availabilityStatus;

    public BookInfo(int id, String title, String author, boolean availabilityStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availabilityStatus = availabilityStatus;
    }
}

public class Book {

    Scanner sc = new Scanner(System.in);

    public static ArrayList<BookInfo> booksInfoList = new ArrayList<>();
    boolean Exit = false;

    public void addBooks() {

        int id;
        String title, author;
        boolean availabilityStatus;
        String choice = "n";
        boolean sameId = false;

        do {
            System.out.println("Enter id");
            id = sc.nextInt();
            sc.nextLine();

            // check for same id present
            for (BookInfo book : booksInfoList) {
                if (book.id == id) {
                    sameId = true;
                    break;
                }
            }

            if (sameId) {
                try {
                    throw new ExistingBookIdException();
                } catch (ExistingBookIdException e) {
                    System.out.println(e.getMessage());
                }
                sameId = false;
            } else {
                System.out.println("Enter Book Title");
                title = sc.nextLine();
                System.out.println("Enter author name");
                author = sc.nextLine();
                System.out.println("Is book Available ? (true/false)");
                availabilityStatus = sc.nextBoolean();
                BookInfo bookInfo = new BookInfo(id, title, author, availabilityStatus);
                booksInfoList.add(bookInfo);

                System.out.println("Data added Successfully");

                System.out.println("Do you want to add other books ? (y/n)");
                choice = sc.next();
            }
        } while (choice.equalsIgnoreCase("y"));
    }

    @Override
    public String toString() {
        return "Book{" +
                "booksInfoList=" + booksInfoList +
                ", Exit=" + Exit +
                '}';
    }

    public void displayAddedBooks() {
        if (booksInfoList.isEmpty()) {
            try {
                throw new NoBooksaddedException();
            } catch (NoBooksaddedException e) {
                System.out.println(e.getMessage());
            }
        } else {
            for (BookInfo book : booksInfoList) {
                System.out.println(book.id + " - " + book.title + " by " + book.author + ", Available: " + book.availabilityStatus);
            }
        }
    }

    public void runMenu() {
        while (!Exit) {
            System.out.println("0. Exit 1. Add books 2. Display books ");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    Exit = true;
                    break;

                case 1:
                    addBooks();
                    break;

                case 2:
                    displayAddedBooks();
                    break;

                default:
                    System.out.println("Enter valid option");
            }

        }
    }
}
