package com.emergency.configuration.person.mapper;

import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.entity.DatShipperEntity;
import com.emergency.configuration.person.dto.DoctorDto;
import com.emergency.configuration.person.dto.ShipperDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T13:50:41+0100",
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
        datDoctorregistryEntity.setIdDoctor( (long) doctorDto.getIdPerson() );
        datDoctorregistryEntity.setMedicalRegistry( doctorDto.getMedicalRegistry() );

        return datDoctorregistryEntity;
    }

    @Override
    public DatShipperEntity shipperDtoToDatShipperEntity(ShipperDto shipperDto) {
        if ( shipperDto == null ) {
            return null;
        }

        DatShipperEntity datShipperEntity = new DatShipperEntity();

        datShipperEntity.setPersonEntity( shipperDtoToDatPersonEntity( shipperDto ) );
        datShipperEntity.setIdShipper( (long) shipperDto.getIdPerson() );
        datShipperEntity.setRegistry( shipperDto.getRegistry() );

        return datShipperEntity;
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

    protected DatPersonEntity shipperDtoToDatPersonEntity(ShipperDto shipperDto) {
        if ( shipperDto == null ) {
            return null;
        }

        DatPersonEntity datPersonEntity = new DatPersonEntity();

        datPersonEntity.setName( shipperDto.getName() );
        datPersonEntity.setFLastname( shipperDto.getFLastname() );
        datPersonEntity.setSecLastname( shipperDto.getSecLastname() );
        datPersonEntity.setNoIdentification( shipperDto.getNoIdentification() );

        return datPersonEntity;
    }
}
