import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Operations {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Movie.class)
                    .addAnnotatedClass(Director.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        boolean exit=true;
        int choice=0;
         while(exit){
             System.out.println("1. Add Director");
             System.out.println("2. Add movie");
             System.out.println("3. Update movie");
             System.out.println("4. Delete movie");
             System.out.println("5. Display movie");
             System.out.println("6. Display Director");
             System.out.println("0. EXIT");

             System.out.println("choose a option :: ");
             choice= Integer.parseInt(bf.readLine());

             switch(choice){
                 case 0:
                     exit=false;
                     break;
                 case 1:
                     addDirector();
                     break;
                 case 2:
                     addMovie();
                     break;
                 case 3:
                     updateMovie();
                     break;
                 case 4:
                     deleteMovie();
                     break;
                 case 5:
                     displayMovie();
                     break;
                 case 6:
                     displayDirector();
                     break;
                 default:
                     System.out.println("Invalid choice");
             }
             sessionFactory.close();
         }
    }
    public  static  void addDirector() throws IOException {
        Session session= sessionFactory.getCurrentSession();
        Transaction tx= session.getTransaction();

        System.out.println("Enter Director Name");
        String directorname=bf.readLine();

        Director director=new Director(directorname);
        session.beginTransaction();
        session.save(director);
        tx.commit();
        session.close();
        System.out.println("Director Added");

    }
    public  static  void addMovie() throws IOException {
        System.out.println("Enter number of movie details you want to add ");
        int noOfMovies= Integer.parseInt(bf.readLine());

        List<Movie> movieList=new ArrayList<Movie>();
        for(int i=0;i<noOfMovies;i++){
            System.out.println("Enter movie name");
            String moviename=bf.readLine();
            System.out.println("Enter director name");
            String directorname=bf.readLine();
            System.out.println("Enter release year");
            int releaseyear= Integer.parseInt(bf.readLine());
            System.out.println("Enter genere ");
            String genere=bf.readLine();

            Session session= sessionFactory.openSession();
            Transaction tx= session.beginTransaction();


//check if the director exists in the table
            Query query= session.createQuery("from Director where directorname=: directorname ");
           query.setParameter("directorname",directorname);
           List<Director> directorList= query.getResultList();

           Director director;
           if(directorList.isEmpty()){
               director= new Director(directorname);//create new entry
               session.persist(director);
           }
           else{
               director=directorList.get(0);//set existing entry
           }

            Movie movie=new Movie(moviename,releaseyear,genere,director);
            session.persist(movie);
            tx.commit();
            session.close();
            System.out.println("movie added");

        }

    }
    public  static  void updateMovie() throws IOException {

        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        System.out.println("Enter movie id :");
        int mid= Integer.parseInt(bf.readLine());

        Movie movie=session.get(Movie.class,mid);

        if(movie==null){
            System.out.println("movie not found");
        }
        else{
            System.out.println("change movie name to :");
            String newMovieName= bf.readLine();
            movie.setMoviename(newMovieName);
        }
        session.update(movie);
        tx.commit();
        System.out.println("data updated ");

    }
    public  static  void deleteMovie() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter movie ID:");
        int mid = Integer.parseInt(bf.readLine());

        Movie movie = session.get(Movie.class, mid);

        if (movie == null) {
            System.out.println("Movie not found");
        } else {
            session.delete(movie);
            transaction.commit();
            System.out.println("Movie deleted successfully");
        }

        session.close();
    }



    public  static  void displayMovie(){
        Session session = sessionFactory.openSession();

//        Query query = session.createQuery("from Movie");
//        List<Movie> movieList = query.getResultList();

        Criteria criteria=session.createCriteria(Movie.class);
        criteria.add(Restrictions.isNotNull("mid"));
        List<Movie> movieList = criteria.list();


        if (movieList.isEmpty()) {
            System.out.println("No movies found");
        } else {
            for (Movie movie : movieList) {
                System.out.println("Movie ID: " + movie.getMid());
                System.out.println("Movie Name: " + movie.getMoviename());
                System.out.println("Release Year: " + movie.getReleaseyear());
                System.out.println("Genre: " + movie.getGenere());
                System.out.println("Director ID: " + movie.getDirector().getDid());
                System.out.println("----------------------");
            }
        }
        session.close();

    }
    public  static  void displayDirector(){
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Director");
        List<Director> directorList = query.getResultList();

        if (directorList.isEmpty()) {
            System.out.println("No directors found");
        } else {
            for (Director director : directorList) {
                System.out.println("Director ID: " + director.getDid());
                System.out.println("Director Name: " + director.getDirectorname());
                System.out.println("----------------------");
            }
        }
        session.close();

    }
}
