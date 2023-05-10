package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Configuration con=new Configuration().configure().addAnnotatedClass(Book.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();

        //logic
        Book book=new Book();
book.setId(1);
        book.setBookName("Let us C");
        book.setAuthorName("Yeshwant Kanetkar");
        book.setPublisherName("Nirali");
        book.setPublishedYear(1999);
        book.setPrice(500);

        session.save(book);
        tx.commit();
        session.close();

        }
    }

