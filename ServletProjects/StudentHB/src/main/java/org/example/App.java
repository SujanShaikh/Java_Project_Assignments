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
        Configuration con=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

        Student student=new Student();
        System.out.println(student.toString());

        student.setName("mrunmai");
        student.setMarks(87);
        student.setId(2);
         session.save(student);
tx.commit();
        System.out.println("Done Successfully");

    }
}
