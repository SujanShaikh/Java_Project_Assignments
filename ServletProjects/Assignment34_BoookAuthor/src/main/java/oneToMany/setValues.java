package oneToMany;

import oneToOne.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class setValues {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Publisher.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Author author = new Author();
        author.setAuthorName("sujan");
        author.setAddress("nanded");

        Book book = new Book();
        book.setBookid(11);
        book.setBookName("unthered soul");
        book.setAuthor(author);

        Book book1 = new Book();
        book1.setBookid(12);
        book1.setBookName(" star");
        book1.setAuthor(author);

        Publisher publisher = new Publisher();
        publisher.setPid(111);
        publisher.setPublisherName("nyati");
        publisher.addBook(book);
        publisher.addBook(book1);

        session.save(book);
        session.save(book1);
        session.save(publisher);

        tx.commit();
        session.close();
    }
}
/*
* mysql> select * from publisher_otm;
+-----+---------------+
| pid | publisherName |
+-----+---------------+
| 111 | nyati         |
+-----+---------------+
1 row in set (0.00 sec)

mysql> select * from book_otm;
+--------+---------------+------------+---------+----------------+
| bookid | BookName      | AuthorName | address | publishers_pid |
+--------+---------------+------------+---------+----------------+
|     12 |  star         | sujan      | nanded  |            111 |
|     11 | unthered soul | sujan      | nanded  |            111 |
+--------+---------------+------------+---------+----------------+
2 rows in set (0.00 sec)
* */
