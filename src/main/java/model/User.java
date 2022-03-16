package model;

import javax.persistence.*;

@MappedSuperclass
public abstract class User {

    @Id
    private String username;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private String password;

    public User(){}

    public User(String username,String email,String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

}
