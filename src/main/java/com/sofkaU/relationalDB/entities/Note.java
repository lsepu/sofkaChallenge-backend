package com.sofkaU.relationalDB.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Note")
@Table(name = "note")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long fkCategoryId;
    private String message;
    private Boolean done;
}
