package com.nimap_assignment.prod_cat.dto;

import com.nimap_assignment.prod_cat.model.Product;
import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String pname;
    private Integer price;
    private CategoryDto category;

    public ProductDto(Integer id, String pname, Integer price, CategoryDto category) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.category = category;
    }

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public static ProductDto fromProduct(Product product) {
        if (product == null) {
            return null;
        }
        CategoryDto categoryDTO = CategoryDto.fromCategory(product.getCategory());
        return new ProductDto(product.getId(), product.getPname(), product.getPrice(), categoryDTO);
    }
}
