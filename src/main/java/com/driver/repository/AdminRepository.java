package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.driver.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
    @Modifying
    @Query("delete from Admin a where a.AdminId =: adminId")
    void deleteAdmin(Integer adminId);
}
