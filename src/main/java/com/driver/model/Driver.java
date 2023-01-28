package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    private String mobile;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean available;

    public Driver(int id, String mobile, boolean available, Admin admin, Cab cab, TripBooking trip, String password) {
        this.id = id;
        this.mobile = mobile;
        this.available = available;
        this.admin = admin;
        this.cab = cab;
        this.trip = trip;
        this.password = password;
    }

    public TripBooking getTrip() {
        return trip;
    }

    public void setTrip(TripBooking trip) {
        this.trip = trip;
    }

    @ManyToOne
      @JoinColumn
      @JsonIgnoreProperties("drivers")
      private Admin admin;

      @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
      @JsonIgnoreProperties("driver")
      private Cab cab;

      @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
      @JsonIgnoreProperties("driver")
      private TripBooking trip;

    public Driver() {
    }

    public Driver(int id, String mobile, String password) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
    }

    private String password;


    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}