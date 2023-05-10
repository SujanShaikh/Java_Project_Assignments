package relationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class).addAnnotatedClass(Subject.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        Laptop laptop = new Laptop();
        laptop.setLname("HP");

        Student student = new Student();
        student.setSname("mrunmai");

        Subject subject1 = new Subject("Maths", student);
        Subject subject2 = new Subject("Science", student);

        List<Subject> subjectList = new ArrayList<Subject>();
        subjectList.add(subject1);
        subjectList.add(subject2);

        List<Teacher> teacherList=new ArrayList<Teacher>();
//        teacherList.add(new Teacher("aarti"));
//        teacherList.add(new Teacher("aniruddha"));
//        teacherList.add(new Teacher("vinay"));

        Teacher t1=new Teacher("aarti");
        Teacher t2=new Teacher("yash");
        Teacher t3=new Teacher("aniruddha");

        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);

        laptop.setStudent(student);
        student.setLaptop(laptop);
        student.setSubject(subjectList);

        subject1.setTeacher(teacherList);
        t1.setSubject(subjectList);

        Student student2 =session.get(Student.class,1);
        System.out.println(" Cache  ");
        System.out.println(student2);
        System.out.println("Something is working ");
        Student student1=session.get(Student.class,1);
        System.out.println(student1);
        System.out.println(" Cache  ");
        System.out.println(session.contains(student1));
        session.save(laptop);
        session.save(subject1);
        session.save(subject2);
        session.save(student);
        session.save(t1);
        session.save(t2);
        session.save(t3);



        tx.commit();

    }
}
