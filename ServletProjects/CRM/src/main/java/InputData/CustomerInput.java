package InputData;

import javax.persistence.*;
@Entity
@Table(name = "user_registration")
public class CustomerInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String email;
    private String password;
    private String fullName;
    private String phone;
    private String address;
    private String gender;
    private String dob;

    @OneToOne(mappedBy = "customerInput")
    private LoginInput loginInput;

//    @ManyToOne
//    private CrmInput crmInput;

    public LoginInput getLoginInput() {
        return loginInput;
    }

    public CustomerInput() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setLoginInput(LoginInput li) {
    }
}