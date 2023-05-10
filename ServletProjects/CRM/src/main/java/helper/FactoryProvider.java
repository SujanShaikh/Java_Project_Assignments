package helper;
import InputData.LoginInput;
import InputData.CustomerInput;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import servlets.*;

public class FactoryProvider {
    public static SessionFactory factory;

    public static SessionFactory getFactory() {
        if(factory==null){
            Configuration con=new Configuration().configure();
            con.addAnnotatedClass(registerServ.class).addAnnotatedClass(CustomerInput.class);
            con.addAnnotatedClass(loginServ.class).addAnnotatedClass(LoginInput.class);
            factory= con.buildSessionFactory();
        }
        return factory;
    }

    public void  closeFactory(){
        if(factory.isOpen()){
            factory.close();
        }
    }
}
