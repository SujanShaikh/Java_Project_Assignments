package InputData;

import servlets.AdminServ;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "crm")
public class CrmInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int crmId;
    private String cname;
    private String address;
    private String email;
    private String password;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "crmId")
//    private List<CustomerInput> customerlist;
    public CrmInput() {
    }

    public int getCrmId() {
        return crmId;
    }

    public void setCrmId(int crmId) {
        this.crmId = crmId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<CustomerInput> getCustomerlist() {
//        return customerlist;
//    }
//
//    public void setCustomerlist(List<CustomerInput> customerlist) {
//        this.customerlist = customerlist;
//    }
}
