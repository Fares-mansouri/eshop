package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Products, Long> {
  //  @Query("SELECT u FROM Products u WHERE u.modelName = ?1")
   // public Products findByModelName(String modelName);
}