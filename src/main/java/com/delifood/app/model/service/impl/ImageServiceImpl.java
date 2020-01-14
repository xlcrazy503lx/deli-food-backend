package com.delifood.app.model.service.impl;

import com.delifood.app.dao.IImageDao;
import com.delifood.app.model.entity.Image;
import com.delifood.app.model.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private IImageDao imageDao;

    @Override
    public Image findById(Long id) {
        return imageDao.findById(id).orElse(null);
    }

    @Override
    public Image findByTableReference(Long idReference, String tableReference) {
        return imageDao.findByIdReferenceAndTableReference(idReference,tableReference);
    }

    @Override
    public Image findByTableReference(String tableReference) {
        return imageDao.findByTableReference(tableReference);
    }

    @Override
    public List<Image> findAll() {
        return (List<Image>) imageDao.findAll();
    }
}
