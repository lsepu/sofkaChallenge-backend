package com.sofkaU.relationalDB.service;


import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.repository.CategoryRepository;
import com.sofkaU.relationalDB.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        //check if category with that id exists
        //remove all notes related to that category
        Category categoryToBeDeleted = categoryRepository.findById(category.getId()).get();
        if (categoryToBeDeleted.getNotes().size() >= 0){
            categoryToBeDeleted.getNotes().forEach(note -> noteRepository.deleteById(note.getId()));
        }

        categoryRepository.deleteById(category.getId());

    }
}
