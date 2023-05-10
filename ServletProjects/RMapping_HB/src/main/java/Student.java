import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Studentdata")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sid;

    private FullName name;

    private int marks;
    @OneToOne
    private Laptop laptops;

//    @OneToMany(mappedBy = "student")
//    private List<Laptop> laptops = new ArrayList<Laptop>();

    public Laptop getLaptops() {
        return laptops;
    }

    public void setLaptops(Laptop laptops) {
        this.laptops = laptops;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }





    public Student(int sid, FullName name, int marks) {
        this.sid = sid;
        this.name = name;
        this.marks = marks;
    }
}
