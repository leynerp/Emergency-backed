package com.emergency.configuration.person.domain.entity;

import com.emergency.common.domain.entity.PersonBase;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "dat_shipper", schema = "mod_person", catalog = "db_emergency")
public class DatShipperEntity extends PersonBase {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idshipper", nullable = false, precision = 0)
    private int idDoctor;
    @Basic
    @Column(name = "registry", nullable = false, length = 255)
    private String registry;


}
