package com.sofkaU.relationalDB.dto;


import lombok.Data;

@Data
public class NoteDTO {

    private Long id;
    private Long fkCategoryId;
    private String message;
    private Boolean done;

}
