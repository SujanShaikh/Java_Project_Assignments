import javax.persistence.*;
import java.util.List;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;
    private String directorname;
    @OneToMany(mappedBy = "director",cascade = CascadeType.ALL)
    private List<Movie> movie;

    public Director() {
    }

    public Director(String directorname){
        this.directorname = directorname;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDirectorname() {
        return directorname;
    }

    public void setDirectorname(String directorname) {
        this.directorname = directorname;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}
