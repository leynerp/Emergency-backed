package com.emergency.configuration.person.dto;

import lombok.Data;

@Data
public class DoctorDto extends PersonDto{
    private String medical_registry;
}
