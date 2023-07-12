package com.emergency.configuration.person.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "nom_documenttype", schema = "mod_configuration", catalog = "db_emergency")
public class NomDocumenttypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, precision = 0)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "active", nullable = false)
    private boolean active;
   }
