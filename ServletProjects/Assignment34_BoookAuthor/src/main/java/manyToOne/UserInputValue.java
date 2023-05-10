package manyToOne;

import oneToOne.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserInputValue {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Publisher.class);
        SessionFactory sf= configuration.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Author author=new Author();
        author.setAid(1);
        author.setAuthorName("sujan");
        author.setAddress("nanded");

        Book book=new Book();
        book.setBookid(11);
        book.setBookName("unthered soul");
        book.setAuthor(author);

        Book book1=new Book();
        book1.setBookid(12);
        book1.setBookName(" star");
        book1.setAuthor(author);



        Publisher publisher=new Publisher();
        publisher.setPid(111);
        publisher.setPublisherName("nyati");

        Publisher publisher1=new Publisher();
        publisher1.setPid(112);
        publisher1.setPublisherName("bhairav");

        book.setPublishers(publisher);
        book1.setPublishers(publisher);

        session.save(book);
        session.save(book1);

        session.save(publisher);
        session.save(publisher1);

        tx.commit();
        session.close();
    }
}
/*
* mysql> select * from book_mto;
+--------+---------------+------------+---------+-----+----------------+
| bookid | BookName      | AuthorName | address | aid | publishers_pid |
+--------+---------------+------------+---------+-----+----------------+
|     11 | unthered soul | sujan     | nanded    |   1 |            111 |
|     12 |  star         | sujan     | nanded    |   1 |            111 |
+--------+---------------+------------+---------+-----+----------------+
2 rows in set (0.07 sec)

mysql> select * from publisher_mto;
+-----+---------------+
| pid | publisherName |
+-----+---------------+
| 111 | nyati         |
| 112 | bhairav       |
+-----+---------------+
2 rows in set (0.00 sec)

mysql>*/