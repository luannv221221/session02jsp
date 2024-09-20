package com.ra.model.dao;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategory();
    // Dinh nghia phuong thuc them moi
    Boolean create(Category category);
}
