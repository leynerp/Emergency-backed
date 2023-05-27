package com.emergency.configuration.person.mapper;

import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.dto.DoctorDto;
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

}
