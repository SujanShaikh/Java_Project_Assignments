import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Director.class).addAnnotatedClass(Song.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction =session.beginTransaction();


        Director director = new Director();
        director.setDrtname("vijay");

        Movie movie1 = new Movie();
        movie1.setMovieName("Alchemy of souls");
        movie1.setDirector(director);

        Movie movie2 = new Movie();
        movie2.setMovieName("Quiet");
        movie2.setDirector(director);

        Set<Movie> movieList = new HashSet<Movie>();
        movieList.add(movie1);
        movieList.add(movie2);

        director.setMovies(movieList);

        session.save(director);
        session.save(movie1);
        session.save(movie2);

        Song song1 = new Song();
        song1.setSname("Song 1");
        song1.setMovie(movie1);

        Song song2 = new Song();
        song2.setSname("Song 2");
        song2.setMovie(movie1);

        Set<Song> songList = new HashSet<Song>();
        songList.add(song1);
        songList.add(song2);

        movie1.setSongs(songList);

        session.save(movie1);
        session.save(song1);
        session.save(song2);

        transaction.commit();


    }
}