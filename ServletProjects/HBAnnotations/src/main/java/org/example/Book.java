package org.example;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "Book_id")

    private int id;
//    @Columns(columns = {
//            @Column(name = "Book_Name"),
//            @Column(name = "Author_Name"),
//            @Column(name="Publisher_Name")
//    })
    private String bookName;
    private String authorName;
    private String publisherName;

//    @Columns(columns = {
//            @Column(name = "Published_Year"),
//            @Column(name="Book_Price")
//    })
    private  int publishedYear,price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                '}';
    }
}
