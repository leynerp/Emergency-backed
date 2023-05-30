package com.emergency.configuration.person.mapper;

import com.emergency.configuration.person.domain.entity.DatAgentEntity;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatShipperEntity;
import com.emergency.configuration.person.dto.AgentDto;
import com.emergency.configuration.person.dto.DoctorDto;
import com.emergency.configuration.person.dto.ShipperDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class );
    @Mapping(source = "idPerson", target = "idDoctor")
    @Mapping(source = "name", target = "personEntity.name")
    @Mapping(source = "FLastname", target = "personEntity.FLastname")
    @Mapping(source = "secLastname", target = "personEntity.secLastname")
    @Mapping(source = "noIdentification", target = "personEntity.noIdentification")
    DatDoctorregistryEntity doctorDtoToDatDoctorEntity(DoctorDto doctorDto);

    @Mapping(source = "idPerson", target = "idShipper")
    @Mapping(source = "name", target = "personEntity.name")
    @Mapping(source = "FLastname", target = "personEntity.FLastname")
    @Mapping(source = "secLastname", target = "personEntity.secLastname")
    @Mapping(source = "noIdentification", target = "personEntity.noIdentification")
    DatShipperEntity shipperDtoToDatShipperEntity(ShipperDto shipperDto);

    @Mapping(source = "idPerson", target = "idAgent")
    @Mapping(source = "name", target = "personEntity.name")
    @Mapping(source = "FLastname", target = "personEntity.FLastname")
    @Mapping(source = "secLastname", target = "personEntity.secLastname")
    @Mapping(source = "noIdentification", target = "personEntity.noIdentification")
    DatAgentEntity agentDtoToDatAgentEntity(AgentDto agentDto);

}
