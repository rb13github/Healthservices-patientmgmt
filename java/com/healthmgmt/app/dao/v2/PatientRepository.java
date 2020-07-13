package com.healthmgmt.app.dao.v2;


import org.springframework.data.jpa.repository.JpaRepository;
import com.healthmgmt.app.entity.v2.Patient;
//ref:https://www.codejava.net/frameworks/spring-boot/spring-boot-crud-example-with-spring-mvc-spring-data-jpa-thymeleaf-hibernate-mysql

public interface PatientRepository extends JpaRepository<Patient,Long> {
 
}
