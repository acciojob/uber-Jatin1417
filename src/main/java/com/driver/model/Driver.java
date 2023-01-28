package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int DriverId;

    private String mobile;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean available;

    public int getDriverId() {
        return DriverId;
    }

    public Driver(int driverId, String mobile, boolean available, Admin admin, Cab cab, TripBooking trip, String password) {
        DriverId = driverId;
        this.mobile = mobile;
        this.available = available;
        this.admin = admin;
        this.cab = cab;
        this.trip = trip;
        this.password = password;
    }

    public void setDriverId(int driverId) {
        DriverId = driverId;
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
    private String password;



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