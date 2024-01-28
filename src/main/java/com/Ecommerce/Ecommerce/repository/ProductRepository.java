package com.Ecommerce.Ecommerce.repository;

import com.Ecommerce.Ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String productName);
}
