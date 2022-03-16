package model;

import javax.persistence.*;

@Entity
@Table(name="vacation_destinations")
public class VacationDestination {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @Column(nullable=false)
    private String location;

    public VacationDestination(String location,Country country) {
        this.location=location;
        this.country = country;
    }

    public VacationDestination() {
    }

    public Country getCountry() {
        return country;
    }

    public String getLocation() {
        return location;
    }
}
