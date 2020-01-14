package com.delifood.app.dao;

import com.delifood.app.model.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageDao extends CrudRepository<Image,Long> {
    Image findByTableReference(String tableReference);
    Image findByIdReferenceAndTableReference(Long idReference, String tableReference);
}
