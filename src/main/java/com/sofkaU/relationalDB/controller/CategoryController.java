package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.dto.CategoryDTO;
import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/v1/categories/")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {

        //map all categories to the DTO
        List<Category> categories = categoryService.findAllCategories();
        List<CategoryDTO> categoriesDTO = categories
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());

        return categoriesDTO;
    }

    @PostMapping("create")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO,Category.class );
        category = categoryService.createCategory(category);
        categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
