package com.sit.softwareprocess.EcommerceProject.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.sku = ?1")
    Product findBySKU(int sku);
}
