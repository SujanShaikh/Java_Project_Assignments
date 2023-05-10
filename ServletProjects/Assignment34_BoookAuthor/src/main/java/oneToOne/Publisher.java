package oneToOne;

import javax.persistence.*;

@Entity
public class Publisher {
    @Id
    private  int Pid;
    private String Pname;
    public Publisher(){

    }


    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }


}
