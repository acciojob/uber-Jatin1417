package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.driver.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    @Query("select * from customer")
    List<Customer> getAllcustomers();

    @Modifying
    @Query("delete from customer c where c.id=:custId ")
    void delete(int custId);

}
