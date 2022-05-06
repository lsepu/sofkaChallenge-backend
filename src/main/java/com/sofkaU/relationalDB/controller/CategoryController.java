package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.dto.CategoryDTO;
import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        if(categoryService.deleteCategory(id)){
            return new ResponseEntity<>("Category successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
    }

}
