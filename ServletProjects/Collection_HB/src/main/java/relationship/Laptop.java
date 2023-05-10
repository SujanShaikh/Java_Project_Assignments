package relationship;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
public  class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int lid;
    private String lname;
    @OneToOne
    private Student student;

    public Laptop() {
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

