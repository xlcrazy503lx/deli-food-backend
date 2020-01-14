package com.delifood.app.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "sub_categories")
public class SubCategory implements Serializable {

    public SubCategory() {
    }

    public SubCategory(String name, String description, String state) {
        this.name = name;
        this.description = description;
        this.state = state;
    }

    private static final long serialVersionUID = 7789921550525922897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false,length = 50, unique = true)
    private String name;

    @Column(nullable = false,length = 120)
    private String description;

    @Column(nullable = false)
    private String state;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
