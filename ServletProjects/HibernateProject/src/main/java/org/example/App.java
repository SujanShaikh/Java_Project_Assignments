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

        UserData ud=new UserData();
        ud.setId(102);
        ud.setName("Mrunmai");
        ud.setCity("Pune");

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserData.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();
        session.save(ud);
        tx.commit();

    }
}
