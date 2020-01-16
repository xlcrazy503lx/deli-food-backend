package com.delifood.app.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "menus")
public class Menu implements Serializable {
    private static final long serialVersionUID = 5052585269711065700L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "menus_dishes", joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "dish_id"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id","dish_id"})})
    private List<Dish> dishes;


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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

}
