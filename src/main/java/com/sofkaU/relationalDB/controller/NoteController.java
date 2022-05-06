package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.dto.CategoryDTO;
import com.sofkaU.relationalDB.dto.NoteDTO;
import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.entities.Note;
import com.sofkaU.relationalDB.service.NoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:3000/")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("create/note")
    public CategoryDTO createNote(@RequestBody NoteDTO noteDTO){
        Note note = modelMapper.map(noteDTO, Note.class);
        Category category =  noteService.createNote(note);
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    @PutMapping("update/note")
    public NoteDTO editNote(@RequestBody NoteDTO noteDTO){
        Note note = modelMapper.map(noteDTO, Note.class);
        note =  noteService.updateNote(note);
        noteDTO = modelMapper.map(note, NoteDTO.class);
        return noteDTO;
    }


}
