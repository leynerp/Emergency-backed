package com.emergency.configuration.nomenclator.domain.entity;

import com.emergency.common.domain.entity.NomBase;

import com.emergency.configuration.nomenclator.dto.EmergencyCodeDto;
import lombok.Data;

import javax.persistence.*;

@SqlResultSetMapping(
        name="MappedCode",
        classes={
                @ConstructorResult(
                        targetClass= EmergencyCodeDto.class,
                        columns={
                                @ColumnResult(name="id", type=Integer.class),
                                @ColumnResult(name="name", type= String.class),
                                @ColumnResult(name="description", type= String.class),
                                @ColumnResult(name="active", type=Boolean.class),
                                @ColumnResult(name="code", type=Integer.class),
                                @ColumnResult(name="idpriority", type=Integer.class),
                                @ColumnResult(name="priorityname" ,type= String.class)})})

@NamedNativeQuery(name = "getAllEmergencyCode",
        query = "SELECT  ec.id,ec.name,ec.description,ec.active,code,idpriority,pr.name as priorityname FROM  mod_configuration.nom_emergencycode as ec inner join  mod_configuration.sorter_priority as pr on (ec.idpriority=pr.id) OFFSET :start  limit :limit ",
        resultSetMapping = "MappedCode")
@Data
@Entity
@Table(name = "nom_emergencycode", schema = "mod_configuration", catalog = "db_emergency")
public class NomEmergencycodeEntity extends NomBase {
    @Basic
    @Column(name = "code")
    private int code;
    @Column(name = "idpriority")
    private  int idPriority;
}
