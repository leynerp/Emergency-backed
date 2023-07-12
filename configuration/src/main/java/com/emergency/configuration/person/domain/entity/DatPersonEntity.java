package com.emergency.configuration.person.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "dat_person", schema = "mod_person", catalog = "db_emergency")
public class DatPersonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idperson", nullable = false, precision = 0)
    private Long idperson;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "f_lastname", nullable = true, length = 255)
    private String firstLastName;
    @Basic
    @Column(name = "sec_lastname", nullable = true, length = 255)
    private String secLastName;
    @Basic
    @Column(name = "no_identification", nullable = true, length = 255)
    private String noIdentification;

    @Basic
    @Column(name = "id_documenttype", nullable = true, length = 255)
    private Long idDocumentType;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_documenttype",insertable = false,updatable = false)
    private NomDocumenttypeEntity documentType;

    @OneToOne(mappedBy = "personEntityDoctor", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DatDoctorregistryEntity doctor;

    @OneToOne(mappedBy = "personEntityShipper", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DatShipperEntity shipper;


    @OneToOne(mappedBy = "personEntityAgent", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DatAgentEntity datAgent;
}
