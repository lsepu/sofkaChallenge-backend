package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.entities.Note;
import com.sofkaU.relationalDB.repository.CategoryRepository;
import com.sofkaU.relationalDB.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService implements INoteService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Category createNote(Note note) {
        Category category = categoryRepository.findById(note.getFkCategoryId()).get();
        category.addNote(note);
        noteRepository.save(note);
        return categoryRepository.save(category);

    }

    @Override
    public void deleteNote(Long noteId) {
        //check if exists
        noteRepository.deleteById(noteId);

    }

    @Override
    public void checkNote(Note note) {
        //check if exists
        noteRepository.save(note);

    }

    @Override
    public void editNote(Note note) {
        //check if exists
        noteRepository.save(note);
    }
}
