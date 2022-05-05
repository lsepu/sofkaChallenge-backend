package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAllCategories();

    Category createCategory(Category category);

    void deleteCategory(Category category);

}
