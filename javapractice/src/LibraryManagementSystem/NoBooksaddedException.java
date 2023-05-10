package LibraryManagementSystem;

public class NoBooksaddedException extends  Exception{
    NoBooksaddedException(){
        System.out.println("Add books first to display list");
    }
}
