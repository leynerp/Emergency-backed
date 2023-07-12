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
    @Mapping(source = "id_person", target = "idDoctor")
    @Mapping(source = "name", target = "personEntityDoctor.name")
    @Mapping(source = "f_last_name", target = "personEntityDoctor.firstLastName")
    @Mapping(source = "s_last_name", target = "personEntityDoctor.secLastName")
    @Mapping(source = "no_identification", target = "personEntityDoctor.noIdentification")
    @Mapping(source = "document_type", target = "personEntityDoctor.documentType.name")
    @Mapping(source = "id_document_type", target = "personEntityDoctor.idDocumentType")
    DatDoctorregistryEntity doctorDtoToDatDoctorEntity(DoctorDto doctorDto);
    @InheritInverseConfiguration
    DoctorDto doctorEntityToDoctorDto(DatDoctorregistryEntity doctorEntity);
    @Mapping(source = "id_person", target = "idShipper")
    @Mapping(source = "name", target = "personEntityShipper.name")
    @Mapping(source = "f_last_name", target = "personEntityShipper.firstLastName")
    @Mapping(source = "s_last_name", target = "personEntityShipper.secLastName")
    @Mapping(source = "no_identification", target = "personEntityShipper.noIdentification")
    @Mapping(source = "document_type", target = "personEntityShipper.documentType.name")
    @Mapping(source = "id_document_type", target = "personEntityShipper.idDocumentType")
    DatShipperEntity shipperDtoToDatShipperEntity(ShipperDto shipperDto);
    @InheritInverseConfiguration
    ShipperDto shipperEntityToShipperDto(DatShipperEntity shipperEntity);

    @Mapping(source = "id_person", target = "idAgent")
    @Mapping(source = "name", target = "personEntityAgent.name")
    @Mapping(source = "f_last_name", target = "personEntityAgent.firstLastName")
    @Mapping(source = "s_last_name", target = "personEntityAgent.secLastName")
    @Mapping(source = "no_identification", target = "personEntityAgent.noIdentification")
    @Mapping(source = "agent_number", target = "agentNumber")
    @Mapping(source = "document_type", target = "personEntityAgent.documentType.name")
    @Mapping(source = "id_document_type", target = "personEntityAgent.idDocumentType")
    DatAgentEntity agentDtoToDatAgentEntity(AgentDto agentDto);

    @InheritInverseConfiguration
    AgentDto agentEntityToAgentDto(DatAgentEntity agentEntity);
    List<AgentDto> agentEntityListToAgentDtoList(List<DatAgentEntity> agentEntityList);
    List<ShipperDto> shipperEntityListToShipperDtoList(List<DatShipperEntity> shipperEntity);
    List<DoctorDto> doctorEntityListToDoctorDtoList(List<DatDoctorregistryEntity> doctorEntity);

}
