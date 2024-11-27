package com.nimap_assignment.prod_cat.product;

import com.nimap_assignment.prod_cat.common.CommonResponse;
import com.nimap_assignment.prod_cat.common.Constants;
import com.nimap_assignment.prod_cat.dto.ProductDto;
import com.nimap_assignment.prod_cat.model.Category;
import com.nimap_assignment.prod_cat.model.Product;
import com.nimap_assignment.prod_cat.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public CommonResponse<Product> saveProduct(Product product) {
        CommonResponse<Product> response = new CommonResponse<>();
        if (product == null || product.getPname() == null || product.getPrice() == null) {
            response.setSuccess(false);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setResponseMessage(Constants.PRODUCT_NOT_BE_NULL);
            return response;
        }

        Product save = productRepository.save(product);
        response.setData(save);
        response.setResponseMessage(Constants.PRODUCT_SAVED_SUCCESSFULLY);
        response.setResponseCode(HttpStatus.CREATED.value());
        response.setSuccess(true);
        return response;
    }

    @Override
    public CommonResponse<Product> getProductById(Integer id) {
        CommonResponse<Product> response = new CommonResponse<>();

        if (id == null) {
            response.setResponseMessage(Constants.PRODUCT_ID_NOT_BE_NULL);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setSuccess(false);
            return response;
        }
        Optional<Product> productOptional = productRepository.findById(id);

        if (!productOptional.isPresent()) {
            response.setResponseMessage(Constants.PRODUCT_NOT_FOUND);
            response.setResponseCode(HttpStatus.NOT_FOUND.value());
            response.setSuccess(false);
            return response;
        }

        Product product = productOptional.get();
		ProductDto productDto=ProductDto.fromProduct(product);

        response.setData(productDto);
        response.setResponseMessage(Constants.PRODUCT_FOUND_SUCCESSFULLY);
        response.setResponseCode(HttpStatus.OK.value());
        response.setSuccess(true);
        return response;
    }

    @Override
    public CommonResponse<Page<Product>> getAllProducts(Integer no, Integer size) {

        CommonResponse<Page<Product>> response = new CommonResponse<>();
        Pageable pageable = PageRequest.of(no, size);
        Page<Product> productList = productRepository.findAll(pageable);

        response.setSuccess(true);
        response.setResponseCode(HttpStatus.FOUND.value());
        response.setResponseMessage(Constants.PRODUCT_FOUND_SUCCESSFULLY);
        response.setData(productList);
        return response;
    }

    @Override
    public CommonResponse<Product> updateProduct(Integer id) {

        CommonResponse<Product> response = new CommonResponse<>();

        if (id == null) {
            response.setResponseMessage(Constants.PRODUCT_ID_NOT_BE_NULL);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setSuccess(false);
            return response;
        }

        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()) {
            response.setSuccess(false);
            response.setResponseCode(HttpStatus.NOT_FOUND.value());
            response.setResponseMessage(Constants.PRODUCT_NOT_FOUND);
            return response;
        }

        Product product1 = product.get();
        product1.setPname(product1.getPname());
        product1.setPrice(product1.getPrice());
//            product1.setCategory(product1.getCategory());

        response.setSuccess(true);
        response.setResponseCode(HttpStatus.FOUND.value());
        response.setResponseMessage(Constants.PRODUCT_UPDATED_SUCCESSFULLY);
        response.setData(product1);
        return response;

    }

    @Override
    public CommonResponse<Product> deleteProductById(Integer id) {

        CommonResponse<Product> response = new CommonResponse<>();

        if (id == null) {
            response.setResponseMessage(Constants.PRODUCT_ID_NOT_BE_NULL);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setSuccess(false);
            return response;
        }

        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()) {
            response.setSuccess(false);
            response.setResponseCode(HttpStatus.NOT_FOUND.value());
            response.setResponseMessage(Constants.PRODUCT_NOT_FOUND);
            return response;
        }

        Product product1 = product.get();
        productRepository.deleteById(id);
        response.setSuccess(true);
        response.setResponseCode(HttpStatus.OK.value());
        response.setResponseMessage(Constants.PRODUCT_DELETED_SUCCESSFULLY);
        response.setData(product1);
        return response;

    }

}
