package com.delifood.app.model.service;

import com.delifood.app.model.entity.Category;
import com.delifood.app.model.entity.SubCategory;

import java.util.List;

public interface ICategoryService {
    Category findById(Long id);
    List<Category> findAll();
    Category addSubCategory(Long idCategory,SubCategory category);
    Category save(Category category);
    Category update(Long id,Category category);
    void delete(Long id);
    Category deleteSubCategory(Long idCategory,Long idSubCategory);
    Category updateSubCategory(Long idCategory,Long idSubCategory,SubCategory subCategory);
}
