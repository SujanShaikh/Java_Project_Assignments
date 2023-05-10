import javax.persistence.*;
import java.util.Set;

@Entity
public class Director {
   @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int directorId;

    private String drtname;

    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;

    public Director(int directorId, String drtname, Set<Movie> movies) {
        this.directorId = directorId;
        this.drtname = drtname;
        this.movies = movies;
    }

    public Director() {
    }

    // getters and setters

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getDrtname() {
        return drtname;
    }

    public void setDrtname(String drtname) {
        this.drtname = drtname;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}