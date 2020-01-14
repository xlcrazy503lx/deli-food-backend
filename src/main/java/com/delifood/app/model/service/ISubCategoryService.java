package com.delifood.app.model.service;

import com.delifood.app.model.entity.SubCategory;

import java.util.List;

public interface ISubCategoryService {
    List<SubCategory> findAll();
    SubCategory findById(Long id);
}
