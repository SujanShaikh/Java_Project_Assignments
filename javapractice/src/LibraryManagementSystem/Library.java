package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

import static LibraryManagementSystem.Book.booksInfoList;

public class Library {
    public void checkBookAvailability(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the book code you want to search ");
        int bookcode=sc.nextInt();

        boolean bookFound = false;
        for (BookInfo book : Book.booksInfoList) {
            if (book.id == bookcode) {
                bookFound = true;
                System.out.println("Book found:");
                System.out.println("ID: " + book.id);
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                if(book.availabilityStatus==false){
                System.out.println("we do have this book but currently its not available");
                }
                else{
                    System.out.println("Its available you can take it");
                }
                break;
            }
        }
      if(!bookFound){
        try{
                throw new NoBooksaddedException();
            } catch (NoBooksaddedException e) {
            System.out.println("currently we dont have this book visit after some time to check");
            }
        }

    }
}
