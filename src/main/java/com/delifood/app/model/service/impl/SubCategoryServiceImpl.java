package com.delifood.app.model.service.impl;

import com.delifood.app.dao.ISubCategoryDao;
import com.delifood.app.model.entity.SubCategory;
import com.delifood.app.model.service.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements ISubCategoryService {

    @Autowired
    private ISubCategoryDao subCategoryDao;

    @Override
    public List<SubCategory> findAll() {
        return (List<SubCategory>) subCategoryDao.findAll();
    }

    @Override
    public SubCategory findById(Long id) {
        return subCategoryDao.findById(id).orElse(null);
    }
}
