package com.delifood.app.response;

import com.delifood.app.model.entity.Category;

import java.util.List;

public class CategoryListResponse {

    public CategoryListResponse() {
    }

    public CategoryListResponse(List<Category> categories) {
        this.categories = categories;
    }

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
