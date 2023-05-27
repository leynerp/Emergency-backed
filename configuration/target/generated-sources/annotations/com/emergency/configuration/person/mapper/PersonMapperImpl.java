package com.emergency.configuration.person.mapper;

import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.dto.DoctorDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-26T09:58:50+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public DatDoctorregistryEntity doctorDtoToDatDoctorEntity(DoctorDto doctorDto) {
        if ( doctorDto == null ) {
            return null;
        }

        DatDoctorregistryEntity datDoctorregistryEntity = new DatDoctorregistryEntity();

        datDoctorregistryEntity.setPersonEntity( doctorDtoToDatPersonEntity( doctorDto ) );
        datDoctorregistryEntity.setIdDoctor( doctorDto.getIdPerson() );
        datDoctorregistryEntity.setMedicalRegistry( doctorDto.getMedicalRegistry() );

        return datDoctorregistryEntity;
    }

    protected DatPersonEntity doctorDtoToDatPersonEntity(DoctorDto doctorDto) {
        if ( doctorDto == null ) {
            return null;
        }

        DatPersonEntity datPersonEntity = new DatPersonEntity();

        datPersonEntity.setName( doctorDto.getName() );
        datPersonEntity.setFLastname( doctorDto.getFLastname() );
        datPersonEntity.setSecLastname( doctorDto.getSecLastname() );
        datPersonEntity.setNoIdentification( doctorDto.getNoIdentification() );

        return datPersonEntity;
    }
}
