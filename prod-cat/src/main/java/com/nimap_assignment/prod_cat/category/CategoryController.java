package com.nimap_assignment.prod_cat.category;

import com.nimap_assignment.prod_cat.common.CommonResponse;
import com.nimap_assignment.prod_cat.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
@RequestMapping("api")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("saveCategory")
    public CommonResponse<Category> saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("getCategoryById/{id}")
    public CommonResponse<Category> getCatById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("getAllCategory/{no}/{size}")
    public CommonResponse<Page<Category>> getAllCategory(@PathVariable Integer no, @PathVariable Integer size) {
        return categoryService.getAllCategories(no, size);
    }

    @PutMapping("updateCategory/{id}")
    public CommonResponse<Category> updateCategory(@PathVariable Integer id,@RequestBody Category category) {
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("deleteCategoryById/{id}")
    public CommonResponse<Category> deleteCategoryById(@PathVariable Integer id) {
        return categoryService.deleteCategoryById(id);
    }

}
