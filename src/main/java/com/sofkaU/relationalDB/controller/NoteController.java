package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.dto.NoteDTO;
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
    public NoteDTO createNote(@RequestBody NoteDTO noteDTO){
        return noteService.createNote(noteDTO);
    }

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    @PutMapping("update/note")
    public NoteDTO editNote(@RequestBody NoteDTO noteDTO){
        return noteService.updateNote(noteDTO);
    }


}
