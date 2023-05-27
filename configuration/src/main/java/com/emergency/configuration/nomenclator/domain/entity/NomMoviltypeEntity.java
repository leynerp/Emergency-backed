package com.emergency.configuration.nomenclator.domain.entity;


import com.emergency.common.domain.entity.NomBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "nom_moviltype", schema = "mod_configuration", catalog = "db_emergency")
public class NomMoviltypeEntity extends NomBase {

}
