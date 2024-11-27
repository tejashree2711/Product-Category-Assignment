package com.nimap_assignment.prod_cat.repository;

import com.nimap_assignment.prod_cat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
