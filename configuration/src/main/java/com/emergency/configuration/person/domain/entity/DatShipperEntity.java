package com.emergency.configuration.person.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dat_shipper", schema = "mod_person", catalog = "db_emergency")
public class DatShipperEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idshipper", nullable = false, precision = 0)
    private Long idShipper;
    @Basic
    @Column(name = "registry", nullable = false, length = 255)
    private String registry;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "idshipper")
    private DatPersonEntity personEntityShipper;


}
