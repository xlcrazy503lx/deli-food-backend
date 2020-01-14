package com.delifood.app.model.service.impl;

import com.delifood.app.dao.ICategoryDao;
import com.delifood.app.model.entity.Category;
import com.delifood.app.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return (List<Category>) categoryDao.findAll();
    }
}
