package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="vacation_packages")
public class VacationPackage {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name="destination_id")
    private VacationDestination vacationDestination;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = false)
    private String endDate;
    @Column
    private String extraDetails;
    @Column(nullable = false)
    private int availableTickets;

    public VacationPackage(String name, VacationDestination vacationDestination, String price, String startDate, String endDate, String extraDetails, int availableTickets) {
        this.name = name;
        this.vacationDestination = vacationDestination;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.extraDetails = extraDetails;
        this.availableTickets = availableTickets;
    }

    public VacationPackage() {
    }

    public String getName() {
        return name;
    }

    public VacationDestination getVacationDestination() {
        return vacationDestination;
    }

    public String getPrice() {
        return price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVacationDestination(VacationDestination vacationDestination) {
        this.vacationDestination = vacationDestination;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }
}
