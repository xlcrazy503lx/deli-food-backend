package com.delifood.app.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "images")
public class Image implements Serializable {
    private static final long serialVersionUID = -5128112260993771210L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_reference",nullable = false)
    private Long idReference;

    @Column(name = "table_reference",nullable = false, length = 50)
    private String tableReference;

    @Column(nullable = false)
    private String unavailable;

    private String normal;

    private String small;

    private String large;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdReference() {
        return idReference;
    }

    public void setIdReference(Long idReference) {
        this.idReference = idReference;
    }

    public String getTableReference() {
        return tableReference;
    }

    public void setTableReference(String tableReference) {
        this.tableReference = tableReference;
    }

    public String getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(String unavailable) {
        this.unavailable = unavailable;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
