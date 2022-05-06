package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.dto.CategoryDTO;
import com.sofkaU.relationalDB.dto.NoteDTO;
import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.entities.Note;

public interface INoteService {

    NoteDTO createNote(NoteDTO noteDTO);

    boolean deleteNote(Long noteId);

    NoteDTO updateNote(NoteDTO noteDTO);
}
