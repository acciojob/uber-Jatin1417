package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "cab")
public class Cab {
    public Cab(int id, int rateKmpl, Boolean availability) {
        this.id = id;
        this.rateKmpl = rateKmpl;
        this.available = availability;
    }

    public Cab() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties("cab")
    private Driver driver;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getRateKmpl() {
        return rateKmpl;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setRateKmpl(int rateKmpl) {
        this.rateKmpl = rateKmpl;
    }



    private int rateKmpl;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean available;


}