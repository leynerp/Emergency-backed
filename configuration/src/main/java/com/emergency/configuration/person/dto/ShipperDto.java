package com.emergency.configuration.person.dto;

import lombok.Data;

@Data
public class ShipperDto {
    private int idPerson;
    private String name;
    private String fLastname;
    private String secLastname;
    private String noIdentification;
    private String registry;
}
