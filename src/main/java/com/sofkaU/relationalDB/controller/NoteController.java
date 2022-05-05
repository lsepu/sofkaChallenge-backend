package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.entities.Note;
import com.sofkaU.relationalDB.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/notes/")
@CrossOrigin(origins = "http://localhost:3000/")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("create")
    public Category createNote(@RequestBody Note note){
        return noteService.createNote(note);
    }

    @DeleteMapping("delete/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    @PutMapping("edit")
    public void editNote(@RequestBody Note note){
        noteService.editNote(note);
    }

    @PutMapping("check")
    public void checkNote(@RequestBody Note note){
        noteService.checkNote(note);
    }


}
