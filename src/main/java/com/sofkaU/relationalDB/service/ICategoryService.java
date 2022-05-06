package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    void deleteCategory(Long categoryId);

}
