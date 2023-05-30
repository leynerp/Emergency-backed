package com.emergency.configuration.person.domain.entity;

import lombok.Data;
import javax.persistence.*;
@Entity
@Data
@Table(name = "dat_doctorregistry", schema = "mod_person", catalog = "db_emergency")
public class DatDoctorregistryEntity  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddoctor", nullable = false, precision = 0)
    private Long idDoctor;
    @Basic
    @Column(name = "medical_registry", nullable = false, length = 255)
    private String medicalRegistry;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "iddoctor")
    private DatPersonEntity personEntity;


}
