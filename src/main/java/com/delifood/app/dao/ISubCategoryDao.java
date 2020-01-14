package com.delifood.app.dao;

import com.delifood.app.model.entity.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubCategoryDao extends CrudRepository<SubCategory,Long> {
}
