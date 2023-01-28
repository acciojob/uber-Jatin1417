package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     @Column(name = "id", nullable = false)
     private int CustomerId;

     @ManyToOne
     @JoinColumn
     @JsonIgnoreProperties("customers")
     private Admin admin;

     public Customer() {
     }

     public TripBooking getTrip() {
          return trip;
     }

     public void setTrip(TripBooking trip) {
          this.trip = trip;
     }


     @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
     @JsonIgnoreProperties("customer")
     private TripBooking trip;

     private String Mobile;

     public int getCustomerId() {
          return CustomerId;
     }

     public void setCustomerId(int customerId) {
          CustomerId = customerId;
     }

     public String getMobile() {
          return Mobile;
     }

     public void setMobile(String mobile) {
          Mobile = mobile;
     }

     public Customer(int customerId, Admin admin, TripBooking trip, String mobile, String password) {
          CustomerId = customerId;
          this.admin = admin;
          this.trip = trip;
          Mobile = mobile;
          Password = password;
     }

     public String getPassword() {
          return Password;
     }

     public void setPassword(String password) {
          Password = password;
     }

     private String Password;




     public Admin getAdmin() {
          return admin;
     }

     public void setAdmin(Admin admin) {
          this.admin = admin;
     }


}