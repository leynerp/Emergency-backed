package com.emergency.configuration.person.mapper;

import com.emergency.configuration.person.domain.entity.DatAgentEntity;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatShipperEntity;
import com.emergency.configuration.person.dto.AgentDto;
import com.emergency.configuration.person.dto.DoctorDto;
import com.emergency.configuration.person.dto.ShipperDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class );
    @Mapping(source = "idPerson", target = "idDoctor")
    @Mapping(source = "name", target = "personEntity.name")
    @Mapping(source = "FLastname", target = "personEntity.fLastname")
    @Mapping(source = "secLastname", target = "personEntity.secLastname")
    @Mapping(source = "noIdentification", target = "personEntity.noIdentification")
    DatDoctorregistryEntity doctorDtoToDatDoctorEntity(DoctorDto doctorDto);
    @InheritInverseConfiguration
    @Mapping(source = "personEntity.FLastname", target = "FLastname")
    DoctorDto doctorEntityToDoctorDto(DatDoctorregistryEntity doctorEntity);
    @Mapping(source = "idPerson", target = "idShipper")
    @Mapping(source = "name", target = "personEntity.name")
    @Mapping(source = "FLastname", target = "personEntity.fLastname")
    @Mapping(source = "secLastname", target = "personEntity.secLastname")
    @Mapping(source = "noIdentification", target = "personEntity.noIdentification")
    DatShipperEntity shipperDtoToDatShipperEntity(ShipperDto shipperDto);
    @InheritInverseConfiguration
    @Mapping(source = "personEntity.FLastname", target = "FLastname")
    ShipperDto shipperEntityToShipperDto(DatShipperEntity shipperEntity);

    @Mapping(source = "idPerson", target = "idAgent")
    @Mapping(source = "name", target = "personEntityAgent.name")
    @Mapping(source = "FLastname", target = "personEntityAgent.fLastname")
    @Mapping(source = "secLastname", target = "personEntityAgent.secLastname")
    @Mapping(source = "noIdentification", target = "personEntityAgent.noIdentification")
    DatAgentEntity agentDtoToDatAgentEntity(AgentDto agentDto);

    @InheritInverseConfiguration
    @Mapping(source = "personEntityAgent.FLastname", target = "FLastname")
    AgentDto agentEntityToAgentDto(DatAgentEntity agentEntity);
    List<AgentDto> agentEntityListToAgentDtoList(List<DatAgentEntity> agentEntityList);
    List<ShipperDto> shipperEntityListToShipperDtoList(List<DatShipperEntity> shipperEntity);
    List<DoctorDto> doctorEntityListToDoctorDtoList(List<DatDoctorregistryEntity> doctorEntity);

}
