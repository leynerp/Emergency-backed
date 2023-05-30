package com.emergency.configuration.person.mapper;

import com.emergency.configuration.person.domain.entity.DatAgentEntity;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.entity.DatShipperEntity;
import com.emergency.configuration.person.dto.AgentDto;
import com.emergency.configuration.person.dto.DoctorDto;
import com.emergency.configuration.person.dto.ShipperDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T14:54:16+0100",
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

    @Override
    public DatAgentEntity agentDtoToDatAgentEntity(AgentDto agentDto) {
        if ( agentDto == null ) {
            return null;
        }

        DatAgentEntity datAgentEntity = new DatAgentEntity();

        datAgentEntity.setPersonEntity( agentDtoToDatPersonEntity( agentDto ) );
        datAgentEntity.setIdAgent( (long) agentDto.getIdPerson() );
        if ( agentDto.getIdentificationNumber() != null ) {
            datAgentEntity.setIdentificationNumber( Long.parseLong( agentDto.getIdentificationNumber() ) );
        }

        return datAgentEntity;
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

    protected DatPersonEntity agentDtoToDatPersonEntity(AgentDto agentDto) {
        if ( agentDto == null ) {
            return null;
        }

        DatPersonEntity datPersonEntity = new DatPersonEntity();

        datPersonEntity.setName( agentDto.getName() );
        datPersonEntity.setFLastname( agentDto.getFLastname() );
        datPersonEntity.setSecLastname( agentDto.getSecLastname() );
        datPersonEntity.setNoIdentification( agentDto.getNoIdentification() );

        return datPersonEntity;
    }
}
