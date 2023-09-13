package com.emergency.configuration.nomenclator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmergencyCodeDto {
    Integer id;
    String name;
    String description;
    Boolean active;
    Integer code;
    Integer idPriority;
    String priorityname;
}
