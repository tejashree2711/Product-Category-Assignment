package com.nimap_assignment.prod_cat.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cname;
    private String cdescription;

    @OneToMany(mappedBy = "category")
    private List<Product> products= new ArrayList<>();
}
