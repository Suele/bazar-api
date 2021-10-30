package com.bazar.api.bazar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Category")
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name", nullable = false, length = 19)
    private String categoryName;

    public Category () {
    }

    public Category (Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId () {
        return categoryId;
    }

    public String getCategoryName () {
        return categoryName;
    }

    @Override
    public String toString () {
        return "Category{" +
                "categoryId:" + categoryId +
                ", categoryName:'" + categoryName + '\'' +
                '}';
    }
}
