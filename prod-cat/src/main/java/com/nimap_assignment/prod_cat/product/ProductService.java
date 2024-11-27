package com.nimap_assignment.prod_cat.product;

import com.nimap_assignment.prod_cat.common.CommonResponse;
import com.nimap_assignment.prod_cat.model.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    public CommonResponse<Product> saveProduct(Product product);
    public CommonResponse<Product> getProductById(Integer id);
    public CommonResponse<Page<Product>> getAllProducts(Integer no, Integer size);
    public CommonResponse<Product> updateProduct(Integer id);
    public CommonResponse<Product> deleteProductById(Integer id);

}
