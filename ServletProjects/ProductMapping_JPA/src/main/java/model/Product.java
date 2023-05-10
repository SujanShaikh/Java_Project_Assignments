package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String pname;
    private Date manufacture;
    private Date Expire;
    @OneToOne(cascade =  CascadeType.ALL)
    private Factory factory;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Consumer> consumer;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Variety> variety;

}