package com.nimap_assignment.prod_cat.category;

import com.nimap_assignment.prod_cat.common.CommonResponse;
import com.nimap_assignment.prod_cat.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    public CommonResponse<Category> saveCategory(Category category);
    CommonResponse<Category> getCategoryById(Integer id);
    public CommonResponse<Page<Category>> getAllCategories(Integer no,Integer size);
    public CommonResponse<Category> updateCategory(Integer id,Category category);
    public CommonResponse<Category> deleteCategoryById(Integer id);
}
