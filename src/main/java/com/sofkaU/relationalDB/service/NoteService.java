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
        //set done initially as false
        note.setDone(false);
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
    public Note updateNote(Note note) {
        //check if exists
        return noteRepository.save(note);
    }

}
