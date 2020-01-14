package com.delifood.app.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "categories")
public class Category implements Serializable {
    private static final long serialVersionUID = 3094252649173768711L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 50, unique = true)
    private String name;

    @Column(nullable = false,length = 120)
    private String description;

    @Column(nullable = false)
    private String state;

    @Transient
    private Image image;


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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
