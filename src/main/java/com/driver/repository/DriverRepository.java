package com.driver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.driver.model.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
     @Query("select * from driver")
     List<Driver> getallDriver();

     @Query(value = "select * from driver d where d.available =:availabiilty order by d.id DESC", nativeQuery = true)
     List<Driver> getAvailableDrivers(boolean availability);

     @Modifying
     @Query("delete from driver d where d.id =:dId")
     void delete(int Did);
}
