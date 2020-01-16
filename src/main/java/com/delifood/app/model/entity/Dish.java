package com.delifood.app.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "dishes")
public class Dish implements Serializable {
    private static final long serialVersionUID = 7060666155345473373L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_default")
    private Product productDefault;

    @ManyToOne
    @JoinColumn(name = "product_category_default")
    private ProductCategory productCategoryDefault;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "dishes_product_categories", joinColumns = @JoinColumn(name = "dish_id"), inverseJoinColumns = @JoinColumn(name = "product_categories_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"dish_id","product_categories_id"})})
    private List<ProductCategory> productCategories;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProductDefault() {
        return productDefault;
    }

    public void setProductDefault(Product productDefault) {
        this.productDefault = productDefault;
    }

    public ProductCategory getProductCategoryDefault() {
        return productCategoryDefault;
    }

    public void setProductCategoryDefault(ProductCategory productCategoryDefault) {
        this.productCategoryDefault = productCategoryDefault;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }
}
