package com.delifood.app.model.service;

import com.delifood.app.model.entity.Image;

import java.util.List;

public interface IImageService {
    Image findById(Long id);
    Image findByTableReference(Long idReference, String tableReference);
    Image findByTableReference(String tableReference);
    List<Image> findAll();
}
