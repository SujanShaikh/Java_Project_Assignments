package oneToOne;

import oneToOne.Author;
import oneToOne.Book;
import oneToOne.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserInput {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Publisher.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Author author = new Author();
        author.setAid(1);
        author.setAuthorName("Manish");
        author.setAddress("Nanded");

        Author author1 = new Author();
        author1.setAid(2);
        author1.setAuthorName("anjali");
        author1.setAddress("pune");

        Book book = new Book();
        book.setBookName("Star");
        book.setAuthor(author);

        Book book1 = new Book();
        book1.setBookName("unthered soul");
        book1.setAuthor(author1);

        Publisher publisher = new Publisher();
        publisher.setPid(11);
        publisher.setPname("nyati");
        book.setPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setPid(12);
        publisher1.setPname("bhairav");
        book1.setPublisher(publisher1);

        session.save(book);
        session.save(publisher);
        session.save(book1);
        session.save(publisher1);

        tx.commit();
        session.close();
    }
}

/*
* mysql> select * from bookAuthor;
+-----+---------------+------------+---------+-----+---------------+
| Bid | BookName      | AuthorName | address | aid | publisher_Pid |
+-----+---------------+------------+---------+-----+---------------+
|   1 | Star          | Manish     | Nanded  |   1 |            11 |
|   2 | unthered soul | anjali     | pune    |   2 |            12 |
+-----+---------------+------------+---------+-----+---------------+
2 rows in set (0.00 sec)

mysql> select * from publisher;
+-----+---------+
| Pid | Pname   |
+-----+---------+
|  11 | nyati   |
|  12 | bhairav |
+-----+---------+
2 rows in set (0.00 sec)
* */
