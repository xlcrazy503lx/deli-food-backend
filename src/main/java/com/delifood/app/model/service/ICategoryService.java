package com.delifood.app.model.service;

import com.delifood.app.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(Long id);
    List<Category> findAll();
}
