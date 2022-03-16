package model;

import javax.persistence.*;

@Entity
@Table(name="travelling_agency")
public class TravellingAgency extends User {

    @Column
    private String name;

    public TravellingAgency(){}

    public TravellingAgency(String username,String email,String password,String name){
        super(username,email,password);
        this.name=name;
    }

}
