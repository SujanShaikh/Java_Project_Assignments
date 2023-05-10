package InputData;

import javax.persistence.*;

@Entity
@Table(name = "login_details")
public class LoginInput {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String userType;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerInput customerInput;

    public CustomerInput getCustomerInput() {
        return customerInput;
    }

    public void setCustomerInput(CustomerInput customerInput) {
        this.customerInput = customerInput;
    }
    public LoginInput() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
