package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.dto.NoteDTO;
import com.sofkaU.relationalDB.service.NoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:3000/")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("create/note")
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody NoteDTO noteDTO){
        noteDTO = noteService.createNote(noteDTO);
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/note/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id){
        if(noteService.deleteNote(id)){
            return new ResponseEntity<>("Note successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Note not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("update/note")
    public ResponseEntity<NoteDTO> editNote(@RequestBody NoteDTO noteDTO){
        noteDTO = noteService.updateNote(noteDTO);
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }


}
