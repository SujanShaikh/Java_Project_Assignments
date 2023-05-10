import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;
    private String moviename;
    private int releaseyear;
    private String genere;

    @ManyToOne(cascade = CascadeType.ALL)
    private Director director;

    public Movie() {
    }

    public Movie(String moviename, int releaseyear, String genere) {
        this.moviename = moviename;
        this.releaseyear = releaseyear;
        this.genere = genere;
    }

    public Movie(String moviename, int releaseyear, String genere, Director director) {
        this.moviename = moviename;
        this.releaseyear = releaseyear;
        this.genere = genere;
        this.director = director;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public int getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(int releaseyear) {
        this.releaseyear = releaseyear;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
