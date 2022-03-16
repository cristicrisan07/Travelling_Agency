package model;

import javax.persistence.*;

@Entity
@Table(name="vacay_seeker")
public class VacaySeeker extends User {

    public VacaySeeker(){}

    public VacaySeeker(String username,String email,String password){
        super(username,email,password);
    }
}
