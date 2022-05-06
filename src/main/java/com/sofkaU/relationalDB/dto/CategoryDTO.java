package com.sofkaU.relationalDB.dto;

import com.sofkaU.relationalDB.entities.Note;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {

    private Long id;

    private String name;

    private List<Note> notes;


}
