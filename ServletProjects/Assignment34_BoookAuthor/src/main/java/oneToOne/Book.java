package oneToOne;

import oneToOne.Author;

import javax.persistence.*;

@Entity
@Table(name = "BookAuthor")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int Bid;
    private String BookName;
    @Embedded
    private Author author;
    @OneToOne
    private Publisher publisher;

    public Book(){

    }

    public int getBid() {
        return Bid;
    }

    public void setBid(int bid) {
        Bid = bid;
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


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
