package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.dto.CategoryDTO;
import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.repository.CategoryRepository;
import com.sofkaU.relationalDB.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    //Mapper used for the DTO
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> findAllCategories() {
        //map all categories to the DTO
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoriesDTO = categories
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
        return categoriesDTO;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Category category = modelMapper.map(categoryDTO, Category.class);
        //set empty list instead of null for notes
        category.setNotes(Collections.emptyList());
        //save in repository
        category = categoryRepository.save(category);

        //returns a DTO
        categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        //check if category with that id exists
        boolean exists = categoryRepository.existsById(categoryId);
        if(!exists){
            return false;
        }
        //remove all notes related to that category
        Category categoryToBeDeleted = categoryRepository.findById(categoryId).get();
        if (categoryToBeDeleted.getNotes().size() >= 0) {
            categoryToBeDeleted.getNotes().forEach(note -> noteRepository.deleteById(note.getId()));
        }

        categoryRepository.deleteById(categoryId);
        return true;

    }
}
