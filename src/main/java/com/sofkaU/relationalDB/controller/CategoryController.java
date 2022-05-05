package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/categories/")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.findAllCategories();
    }

    @PostMapping("create")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

}
