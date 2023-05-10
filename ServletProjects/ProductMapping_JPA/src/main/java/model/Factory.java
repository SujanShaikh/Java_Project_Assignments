package model;

import lombok.Getter;
import lombok.Setter;
import model.Product;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    private String fname;
    private Date estbDate;
    @OneToOne(cascade =  CascadeType.ALL)
    private Product product;

}
