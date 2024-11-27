package com.nimap_assignment.prod_cat.product;

import com.nimap_assignment.prod_cat.common.CommonResponse;
import com.nimap_assignment.prod_cat.model.Category;
import com.nimap_assignment.prod_cat.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("saveProduct")
    public CommonResponse<Product> saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("getProductById/{id}")
    public CommonResponse<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("getAllProducts/{no}/{size}")
    public CommonResponse<Page<Product>> getAllProducts(@PathVariable Integer no, @PathVariable Integer size) {
        return productService.getAllProducts(no, size);
    }

    @PutMapping("updateProduct/{id}")
    public CommonResponse<Product> updateProduct(@PathVariable Integer id) {
        return productService.updateProduct(id);
    }

    @DeleteMapping("deleteProductById/{id}")
    public CommonResponse<Product> deleteProductById(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }

}
