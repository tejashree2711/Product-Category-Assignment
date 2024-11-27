package com.nimap_assignment.prod_cat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private Integer id;
    private String pname;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "cid", nullable = false)
    @JsonBackReference
    private Category category;
}
