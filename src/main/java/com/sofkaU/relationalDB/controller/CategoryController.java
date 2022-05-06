package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.dto.CategoryDTO;
import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("get/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping("create/category")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @DeleteMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
