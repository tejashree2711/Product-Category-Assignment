package com.nimap_assignment.prod_cat.repository;

import com.nimap_assignment.prod_cat.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
