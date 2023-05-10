package oneToMany;

import oneToOne.Author;

import javax.persistence.*;

@Entity
@Table(name = "Book_otm")
public class Book {
    @Id
    private int bookid;
    private String BookName;
    private Author author;
    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publishers;

    public Publisher getPublishers() {
        return publishers;
    }

    public void setPublishers(Publisher publishers) {
        this.publishers = publishers;
    }

    public Book() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}