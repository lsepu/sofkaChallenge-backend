package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.dto.NoteDTO;
import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.entities.Note;
import com.sofkaU.relationalDB.repository.CategoryRepository;
import com.sofkaU.relationalDB.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService implements INoteService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        Note note = modelMapper.map(noteDTO, Note.class);
        note.setDone(false);
        Category category = categoryRepository.findById(note.getFkCategoryId()).get();
        category.addNote(note);
        noteRepository.save(note);
        categoryRepository.save(category);

        noteDTO = modelMapper.map(note , NoteDTO.class);
        return noteDTO;
    }

    @Override
    public boolean deleteNote(Long noteId) {
        boolean exists = noteRepository.existsById(noteId);
        if(!exists){
            return false;
        }
        noteRepository.deleteById(noteId);
        return true;
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        boolean exists = noteRepository.existsById(noteDTO.getId());
        if(!exists){
            throw new IllegalStateException(
                    "Note with id " + noteDTO.getId() + " does not exists"
            );
        }
        Note note = modelMapper.map(noteDTO, Note.class);
        note =  noteRepository.save(note);
        noteDTO = modelMapper.map(note, NoteDTO.class);
        return noteDTO;
    }

}
