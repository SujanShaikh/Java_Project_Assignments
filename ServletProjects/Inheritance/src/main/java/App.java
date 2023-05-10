import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(PartTimeEmp.class)
                .addAnnotatedClass(FullTimeEmp.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee(1, "sujan");
        Employee employee1 = new Employee(2, "mrunmai");

        PartTimeEmp partTimeEmp = new PartTimeEmp(3, "arya", 500, 5);
        FullTimeEmp fullTimeEmp = new FullTimeEmp(4, "aditi", 6769, 8, 490);

        // Save or update objects to the session
        session.saveOrUpdate(employee);
        session.saveOrUpdate(employee1);
        session.saveOrUpdate(partTimeEmp);
        session.saveOrUpdate(fullTimeEmp);

        transaction.commit();
        session.close();
        sf.close();
    }
}
