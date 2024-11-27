package com.nimap_assignment.prod_cat.category;

import com.nimap_assignment.prod_cat.common.CommonResponse;
import com.nimap_assignment.prod_cat.common.Constants;
import com.nimap_assignment.prod_cat.model.Category;
import com.nimap_assignment.prod_cat.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CommonResponse<Category> saveCategory(Category category) {
        CommonResponse<Category> response = new CommonResponse<>();
        if (category == null || category.getCname() == null) {
            response.setSuccess(false);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setResponseMessage(Constants.CATEGORY_NOT_BE_NULL);
            return response;
        }
//        || category.getCid() == null
        Category savedCategory = categoryRepository.save(category);
        response.setData(savedCategory);
        response.setResponseMessage(Constants.CATEGORY_SAVED_SUCCESSFULLY);
        response.setResponseCode(HttpStatus.CREATED.value());
        response.setSuccess(true);
        return response;
    }

    @Override
    public CommonResponse<Category> getCategoryById(Integer id) {
        CommonResponse<Category> response = new CommonResponse<>();

        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            response.setData(category);
            response.setResponseMessage(Constants.CATEGORY_FOUND_SUCCESSFULLY);
            response.setResponseCode(HttpStatus.FOUND.value());
            response.setSuccess(true);
            return response;
        }
        response.setData(category);
        response.setResponseMessage(Constants.CATEGORY_NOT_FOUND);
        response.setResponseCode(HttpStatus.NOT_FOUND.value());
        response.setSuccess(true);
        return response;

    }

    @Override
    public CommonResponse<Page<Category>> getAllCategories(Integer no, Integer size) {
        CommonResponse<Page<Category>> response = new CommonResponse<>();
        Pageable pageable = PageRequest.of(no, size);
        Page<Category> all = categoryRepository.findAll(pageable);

        response.setSuccess(true);
        response.setResponseCode(HttpStatus.FOUND.value());
        response.setResponseMessage(Constants.CATEGORY_FOUND_SUCCESSFULLY);
        response.setData(all);
        return response;
    }


    @Override
    public CommonResponse<Category> updateCategory(Integer id, Category category) {
        CommonResponse<Category> response = new CommonResponse<>();
        Optional<Category> existingCategoryOptional = categoryRepository.findById(id);

        if (existingCategoryOptional.isPresent()) {
            Category existingCategory = existingCategoryOptional.get();

            existingCategory.setCname(category.getCname());
            existingCategory.setCdescription(category.getCdescription()); // Update the description field

            Category updatedCategory = categoryRepository.save(existingCategory);

            response.setSuccess(true);
            response.setResponseCode(HttpStatus.OK.value());
            response.setResponseMessage(Constants.CATEGORY_UPDATED_SUCCESSFULLY);
            response.setData(updatedCategory);
        } else {

            response.setSuccess(false);
            response.setResponseCode(HttpStatus.NOT_FOUND.value());
            response.setResponseMessage(Constants.CATEGORY_NOT_FOUND);
            response.setData(null);
        }
        return response;
    }


    @Override
    public CommonResponse<Category> deleteCategoryById(Integer id) {
        CommonResponse<Category> response = new CommonResponse<>();
            categoryRepository.deleteById(id);
            response.setSuccess(true);
            response.setResponseCode(HttpStatus.OK.value());
            response.setResponseMessage(Constants.CATEGORY_DELETED_SUCCESSFULLY);
            return response;
        }
}