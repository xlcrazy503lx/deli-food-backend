package com.delifood.app.controller;

import com.delifood.app.model.entity.Category;
import com.delifood.app.model.service.ICategoryService;
import com.delifood.app.model.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IImageService imageService;

    @GetMapping("/")
    public List<Category> findAll(){
        List<Category> categories = categoryService.findAll();
        List<Category> returnVale = new ArrayList<>();
        for (Category cat:categories) {
            cat.setImage(imageService.findByTableReference(cat.getId(),"categories"));
            returnVale.add(cat);
        }
        return returnVale;
    };

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        category.setImage(imageService.findByTableReference(id,"categories"));
        return category;
    }
}
