import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PART_TIME")
public class PartTimeEmp extends Employee{

    private int hrs_sal,no_of_hrs;
    public PartTimeEmp(int id, String name, int hrs_sal, int no_of_hrs) {
        super(id, name);
        this.hrs_sal = hrs_sal;
        this.no_of_hrs = no_of_hrs;
    }
}

