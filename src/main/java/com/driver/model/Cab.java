package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "cab")
public class Cab {
    public int getPerKmRate() {
        return PerKmRate;
    }

    public Cab(int id, Driver driver, int perKmRate, Boolean available) {
        this.id = id;
        this.driver = driver;
        PerKmRate = perKmRate;
        this.available = available;
    }

    public void setPerKmRate(int perKmRate) {
        PerKmRate = perKmRate;
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


    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }




    private int PerKmRate;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean available;


}