package com.emergency.common.domain.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class PersonBase {
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "f_lastname", nullable = true, length = 255)
    private String fLastname;
    @Basic
    @Column(name = "sec_lastname", nullable = true, length = 255)
    private String secLastname;
    @Basic
    @Column(name = "no_identification", nullable = true, length = 255)
    private String noIdentification;
}
