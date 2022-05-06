package com.sofkaU.relationalDB.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class NoteDTO {

    private Long id;

    @NotNull(message = "Category required")
    private Long fkCategoryId;

    @NotBlank(message = "message required")
    private String message;
    private Boolean done;

}
