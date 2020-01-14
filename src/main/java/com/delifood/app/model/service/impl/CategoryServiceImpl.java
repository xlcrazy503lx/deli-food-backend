package com.delifood.app.model.service.impl;

import com.delifood.app.dao.ICategoryDao;
import com.delifood.app.dao.ISubCategoryDao;
import com.delifood.app.model.entity.Category;
import com.delifood.app.model.entity.SubCategory;
import com.delifood.app.model.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;
    @Autowired
    private ISubCategoryDao subCategoryDao;

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category addSubCategory(Long idCategory,SubCategory subCategory) {
        Category cat = categoryDao.findById(idCategory).orElse(null);
        if (cat!= null){
            cat.getSubCategories().add(subCategory);
            return categoryDao.save(cat);
        }
        return null;
    }

    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Category insert = categoryDao.findById(id).orElse(null);
        if (insert != null){
            insert.setName(category.getName());
            insert.setDescription(category.getDescription());
            insert.setState(category.getState());
            insert.setId(id);
            return categoryDao.save(insert);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        categoryDao.deleteById(id);
    }

    @Override
    public Category deleteSubCategory(Long idCategory, Long idSubCategory) {
        Category cat = categoryDao.findById(idCategory).orElse(null);
        if (cat!= null){
            subCategoryDao.findById(idSubCategory).ifPresent(sub -> cat.getSubCategories().remove(sub));
            return categoryDao.save(cat);
        }
        return null;
    }

    @Override
    public Category updateSubCategory(Long idCategory, Long idSubCategory, SubCategory subCategory) {
        Category cat = categoryDao.findById(idCategory).orElse(null);
        if (cat!= null){
            SubCategory sub =subCategoryDao.findById(idSubCategory).orElse(null);
            if (sub != null){
                cat.getSubCategories().remove(sub);
                sub.setName(subCategory.getName());
                sub.setDescription(subCategory.getDescription());
                sub.setState(subCategory.getState());
                cat.getSubCategories().add(sub);
            }
            return categoryDao.save(cat);
        }
        return null;
    }
}
