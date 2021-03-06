package com.delifood.app.controller;

import com.delifood.app.model.entity.Category;
import com.delifood.app.model.entity.SubCategory;
import com.delifood.app.model.service.ICategoryService;
import com.delifood.app.model.service.IImageService;
import com.delifood.app.response.CategoryListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IImageService imageService;

    @GetMapping("/")
    public CategoryListResponse findAll(){
        List<Category> categoryList = categoryService.findAll();
        categoryList.forEach(c -> {
            if (c.getSubCategories().size()>0){
                c.setSubCategory("Si");
                c.getSubCategories().forEach(s -> {
                    s.setImage(imageService.findByTableReference(s.getId(),"sub_categories"));
                });
            }
            c.setImage(imageService.findByTableReference(c.getId(),"categories"));
        });
        return new CategoryListResponse(categoryList);
    };

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
       return categoryService.findById(id);
    }

    @PostMapping("/")
    public Category addCategory(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody Category category){
        return categoryService.update(id,category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
    }

}
