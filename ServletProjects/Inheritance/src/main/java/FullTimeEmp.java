import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FULL_TIME")
public class FullTimeEmp extends  Employee{


    private int fix_sal,extra_no_of_hrs,extra_hrs_sal;

    public FullTimeEmp(int id, String name, int fix_sal, int extra_no_of_hrs, int extra_hrs_sal) {
        super(id, name);
        this.fix_sal = fix_sal;
        this.extra_no_of_hrs = extra_no_of_hrs;
        this.extra_hrs_sal = extra_hrs_sal;
    }


}
