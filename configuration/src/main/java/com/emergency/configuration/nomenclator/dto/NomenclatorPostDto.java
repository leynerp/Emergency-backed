package com.emergency.configuration.nomenclator.dto;

import lombok.Data;

@Data
public class NomenclatorPostDto {
    String denomination;
    String description;
    Boolean active ;
    Integer code;
}
