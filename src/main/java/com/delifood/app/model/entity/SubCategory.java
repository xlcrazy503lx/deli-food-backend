package com.delifood.app.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "sub_categories")
public class SubCategory implements Serializable {

    public SubCategory() {
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


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "sub_categories_menus", joinColumns = @JoinColumn(name = "sub_category_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"sub_category_id","menu_id"})})
    private List<Menu> menusSubCategories;

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

    public List<Menu> getMenusSubCategories() {
        return menusSubCategories;
    }

    public void setMenusSubCategories(List<Menu> menusSubCategories) {
        this.menusSubCategories = menusSubCategories;
    }
}
