package com.emergency.common.domain.entity;

import lombok.Data;

import javax.persistence.*;
@MappedSuperclass
@Data
public class NomBase {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "active")
    private boolean active;
}
