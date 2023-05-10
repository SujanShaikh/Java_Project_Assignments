package LibraryManagementSystem;

import java.util.Scanner;

public class libmgmt {
    public static void main(String[] args) {
        boolean Exit=false;
        Scanner sc= new Scanner(System.in);
        while (!Exit){
            System.out.println("0. exit 1. Books 2.User 3. Library ");
            int choice= sc.nextInt();
            switch (choice){
                case 0:
                    Exit=true;
                    break;

                case 1:
                    Book book=new Book();
                    book.runMenu();
                    break;

                case 2:
                    Library library=new Library();
                    library.checkBookAvailability();

                    break;

                default:
                    System.out.println("Enter valid option");
            }

        }
    }
}
