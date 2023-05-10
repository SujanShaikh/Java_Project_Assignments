package TablePerClass;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PART_TIME")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="name", column=@Column(name="name"))
})
public class PartTimeEmp extends Employee {

    private int hrs_sal,no_of_hrs;
    public PartTimeEmp(int id, String name, int hrs_sal, int no_of_hrs) {
        super(id, name);
        this.hrs_sal = hrs_sal;
        this.no_of_hrs = no_of_hrs;
    }
}
