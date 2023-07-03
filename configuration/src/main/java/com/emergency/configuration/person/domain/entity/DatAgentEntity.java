package com.emergency.configuration.person.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "dat_agent", schema = "mod_person", catalog = "db_emergency")
public class DatAgentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idagent", nullable = false, precision = 0)
    private Long idAgent;

    @Basic
    @Column(name = "indentification_number", nullable = false, precision = 0)
    private Long identificationNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "idagent")
    private DatPersonEntity personEntityAgent;


}
