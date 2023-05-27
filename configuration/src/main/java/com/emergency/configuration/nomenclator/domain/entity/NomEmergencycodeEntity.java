package com.emergency.configuration.nomenclator.domain.entity;

import com.emergency.common.domain.entity.NomBase;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "nom_emergencycode", schema = "mod_configuration", catalog = "db_emergency")
public class NomEmergencycodeEntity extends NomBase {
    @Basic
    @Column(name = "code")
    private int code;
}
