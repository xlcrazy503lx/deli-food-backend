package com.delifood.app.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = -5113026151237749353L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_categories_products", joinColumns = @JoinColumn(name = "product_categories_id"), inverseJoinColumns = @JoinColumn(name = "product_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"product_categories_id", "product_id"})})
    private List<Product> products;


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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
