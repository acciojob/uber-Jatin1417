package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     @Column(name = "id", nullable = false)
     private int id;

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

     public Customer(int id, Admin admin, String customerName, String customerPassword) {
          this.id = id;
          this.admin = admin;
          this.customerName = customerName;
          this.customerPassword = customerPassword;
     }
     @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
     @JsonIgnoreProperties("customer")
     private TripBooking trip;

     private String customerName;
     private String customerPassword;


     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public Admin getAdmin() {
          return admin;
     }

     public void setAdmin(Admin admin) {
          this.admin = admin;
     }

     public String getCustomerName() {
          return customerName;
     }

     public void setCustomerName(String customerName) {
          this.customerName = customerName;
     }

     public String getCustomerPassword() {
          return customerPassword;
     }

     public void setCustomerPassword(String customerPassword) {
          this.customerPassword = customerPassword;
     }
}