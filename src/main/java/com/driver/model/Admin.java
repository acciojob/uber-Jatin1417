package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    public Admin() {
    }

    public Admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        Password = password;
    }

    private String username;

    private String Password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("admin")
    private List<Customer> customers;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("admin")
    private List<Driver> drivers;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setPassword(String password) {
        Password = password;
    }
}