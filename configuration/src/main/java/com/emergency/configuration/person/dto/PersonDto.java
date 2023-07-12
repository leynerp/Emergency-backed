package com.emergency.configuration.person.dto;

import lombok.Data;

@Data
public class PersonDto {
    private int id_person;
    private String name;
    private String f_last_name;
    private String s_last_name;
    private String no_identification;
    private String document_type;
    private Long id_document_type;
}
