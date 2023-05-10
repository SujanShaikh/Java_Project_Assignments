import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Config {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Answer.class).addAnnotatedClass(Question.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Question q = new Question();
        q.setQuestion("who are you ?");

        Answer answer = new Answer();
        answer.setSid(12);
        answer.setAnswer("i am Sujan");
        answer.setQuestion(q);

        Answer answer1 = new Answer();
        answer1.setSid(13);
        answer1.setAnswer("I am aditi");
        answer1.setQuestion(q);


        Answer answer2 = new Answer();
        answer2.setSid(14);
        answer2.setAnswer("I am arya");
        answer2.setQuestion(q);





//        answer.setQuestion(q);

//        Question q1 = new Question();
//        q1.setQuestion("you are in which team ?");
//        q1.setAnswer(answer1);
//        answer1.setQuestion(q1);

        session.save(q);
        session.save(answer);
//        session.save(q1);
        session.save(answer1);
        session.save(answer2);

        tx.commit();

        session.close();
    }
}
