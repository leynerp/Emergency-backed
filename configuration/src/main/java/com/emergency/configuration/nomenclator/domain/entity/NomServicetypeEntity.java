package com.emergency.configuration.nomenclator.domain.entity;

import com.emergency.common.domain.entity.NomBase;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "nom_servicetype", schema = "mod_configuration", catalog = "db_emergency")
public class NomServicetypeEntity extends NomBase {

}
