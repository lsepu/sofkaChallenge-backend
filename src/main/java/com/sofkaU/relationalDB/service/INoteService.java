package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.entities.Category;
import com.sofkaU.relationalDB.entities.Note;

public interface INoteService {

    Category createNote(Note note);

    void deleteNote(Long noteId);

    void checkNote(Note note);

    void editNote(Note note);
}
