package java_week2_classwork.Encapsulation.Q1;

class BookFind{
    private String title;
    private int isbn;
    private  String author;
    private  Boolean isBoolean=false;


    public BookFind(String title,int isbn,String author){
        this.title=title;
        this.isbn=isbn;
        this.author=author;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void borrow(String bookrequired){
        if(getTitle().equalsIgnoreCase(bookrequired)) {
            isBoolean = true;
            System.out.println(isBoolean);
        }else {
            System.out.println(isBoolean);
        }
    }
}
public class Library {
    public static void main(String[] args) {
        BookFind bookFind=new BookFind("Secret",1211456789,"Sujan");
        bookFind.borrow("Secret");

    }
}
