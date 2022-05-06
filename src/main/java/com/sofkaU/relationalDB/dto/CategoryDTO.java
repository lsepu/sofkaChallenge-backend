package com.sofkaU.relationalDB.dto;

import com.sofkaU.relationalDB.entities.Note;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CategoryDTO {

    private Long id;

    @NotBlank(message = "Category name required")
    private String name;

    private List<Note> notes;


}
