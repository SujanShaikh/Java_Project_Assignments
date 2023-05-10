package oneToOne;

import javax.persistence.*;

@Embeddable
public class Author {
   @Transient
    private int aid;
    private String AuthorName,address;

    public String getAddress() {
        return address;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Author() {

    }
    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

}
