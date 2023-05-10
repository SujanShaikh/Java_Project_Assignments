package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Variety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vid;
    private String vname;
    @ManyToMany(mappedBy = "consumer",cascade = CascadeType.ALL)
    private List<Product> product;

}