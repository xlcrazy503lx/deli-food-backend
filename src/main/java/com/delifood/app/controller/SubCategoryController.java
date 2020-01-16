package com.delifood.app.controller;


import com.delifood.app.model.entity.Category;
import com.delifood.app.model.entity.SubCategory;
import com.delifood.app.model.service.ICategoryService;
import com.delifood.app.model.service.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISubCategoryService subCategoryService;

    @PostMapping("/{idCategory}")
    public Category addSubCategory(@RequestBody SubCategory subCategory, @PathVariable Long idCategory){
        return categoryService.addSubCategory(idCategory,subCategory);
    }
    @GetMapping("/")
    public List<SubCategory> findAll(){
        return subCategoryService.findAll();
    }

    @DeleteMapping("/{idCategory}/{idSubCategory}")
    public void deleteSubCategory(@PathVariable Long idCategory, @PathVariable Long idSubCategory){
        categoryService.deleteSubCategory(idCategory, idSubCategory);
    }

    @PutMapping("/{idCategory}/{idSubCategory}")
    public void updateSubCategory(@PathVariable Long idCategory, @PathVariable Long idSubCategory, @RequestBody SubCategory subCategory){
        categoryService.updateSubCategory(idCategory, idSubCategory,subCategory);
    }
}
