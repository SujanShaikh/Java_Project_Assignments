package LibraryManagementSystem;

public class ExistingBookIdException extends  Exception{
    ExistingBookIdException(){
        System.out.println("The Book id is already taken");
    }
}
