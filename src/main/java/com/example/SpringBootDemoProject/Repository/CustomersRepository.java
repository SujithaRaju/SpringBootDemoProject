package com.example.SpringBootDemoProject.Repository;

import com.example.SpringBootDemoProject.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
    @Query("FROM Customers WHERE CUSTOMERID = :CustomerID")
    Customers findByCustomerId(@Param("CustomerID") Long id);
}
