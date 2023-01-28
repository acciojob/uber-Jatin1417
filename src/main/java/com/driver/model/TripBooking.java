package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "trip")
public class TripBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int tripBookingId;


    public TripStatus getStatus() {
        return Status;
    }

    public void setStatus(TripStatus status) {
        Status = status;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public int getDistanceInKm() {
        return DistanceInKm;
    }

    public void setDistanceInKm(int distanceInKm) {
        DistanceInKm = distanceInKm;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }



    public int getBill() {
        return Bill;
    }

    public void setBill(int bill) {
        Bill = bill;
    }

    @Enumerated(EnumType.STRING)
    private TripStatus Status;

    public int getTripBookingId() {
        return tripBookingId;
    }

    public void setTripBookingId(int tripBookingId) {
        this.tripBookingId = tripBookingId;
    }

    private String fromLocation;

    private String toLocation;

    private int DistanceInKm;

    private int Bill;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("trip")
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public TripBooking() {
    }

    public TripBooking(int tripBookingId, TripStatus tripStatus, String fromLocation, String toLocation, int distanceInKm, int bill, Driver driver, Customer customer) {
        this.tripBookingId = tripBookingId;
        this.Status = tripStatus;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        DistanceInKm = distanceInKm;
        Bill = bill;
        this.driver = driver;
        this.customer = customer;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("trip")
    private Customer customer;

}