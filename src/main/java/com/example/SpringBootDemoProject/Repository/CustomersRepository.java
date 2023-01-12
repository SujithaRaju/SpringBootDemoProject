package com.example.SpringBootDemoProject.Repository;
import com.example.SpringBootDemoProject.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Products, Long> {
    @Query("FROM Products WHERE PRODUCTID = :ProductID")
    Products findByCustomerId(@Param("ProductID") Long id);
}
