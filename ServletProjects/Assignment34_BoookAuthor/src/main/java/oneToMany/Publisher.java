package oneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Publisher_otm")
public class Publisher {
    @Id
    private int pid;
    private String publisherName;
    @OneToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
    private List<Book> book =new ArrayList<>();

    public Publisher() {    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
    public void addBook(Book book) {
        this.book.add(book);
        book.setPublishers(this); // set the publisher for the book
    }
}
