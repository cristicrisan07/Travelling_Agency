package model;

import javax.persistence.*;

@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;

    public Country(String name){
        this.name=name;
    }

    public Country() {

    }

    public String getName() {
        return name;
    }
}
