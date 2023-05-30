package com.emergency.configuration.nomenclator.mapper;

import com.emergency.common.domain.entity.NomBase;
import com.emergency.configuration.nomenclator.domain.entity.NomEmergencycodeEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomHealthunitEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomMoviltypeEntity;
import com.emergency.configuration.nomenclator.dto.NomenclatorPostDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T09:40:03+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class NomenclatorMapperImpl implements NomenclatorMapper {

    @Override
    public NomEmergencycodeEntity nomenclatorDtoToNomEmergencyEntity(NomenclatorPostDto nomenclatorDto) {
        if ( nomenclatorDto == null ) {
            return null;
        }

        NomEmergencycodeEntity nomEmergencycodeEntity = new NomEmergencycodeEntity();

        nomEmergencycodeEntity.setName( nomenclatorDto.getDenomination() );
        nomEmergencycodeEntity.setDescription( nomenclatorDto.getDescription() );
        if ( nomenclatorDto.getActive() != null ) {
            nomEmergencycodeEntity.setActive( nomenclatorDto.getActive() );
        }
        if ( nomenclatorDto.getCode() != null ) {
            nomEmergencycodeEntity.setCode( nomenclatorDto.getCode() );
        }

        return nomEmergencycodeEntity;
    }

    @Override
    public NomHealthunitEntity nomenclatorDtoToNomHealthunitEntity(NomenclatorPostDto nomenclatorDto) {
        if ( nomenclatorDto == null ) {
            return null;
        }

        NomHealthunitEntity nomHealthunitEntity = new NomHealthunitEntity();

        nomHealthunitEntity.setName( nomenclatorDto.getDenomination() );
        nomHealthunitEntity.setDescription( nomenclatorDto.getDescription() );
        if ( nomenclatorDto.getActive() != null ) {
            nomHealthunitEntity.setActive( nomenclatorDto.getActive() );
        }

        return nomHealthunitEntity;
    }

    @Override
    public NomMoviltypeEntity nomenclatorDtoToNomMoviltypeEntity(NomenclatorPostDto nomenclatorDto) {
        if ( nomenclatorDto == null ) {
            return null;
        }

        NomMoviltypeEntity nomMoviltypeEntity = new NomMoviltypeEntity();

        nomMoviltypeEntity.setName( nomenclatorDto.getDenomination() );
        nomMoviltypeEntity.setDescription( nomenclatorDto.getDescription() );
        if ( nomenclatorDto.getActive() != null ) {
            nomMoviltypeEntity.setActive( nomenclatorDto.getActive() );
        }

        return nomMoviltypeEntity;
    }

    @Override
    public NomenclatorPostDto nomBaseToNomenclatorDto(NomBase nomBase) {
        if ( nomBase == null ) {
            return null;
        }

        NomenclatorPostDto nomenclatorPostDto = new NomenclatorPostDto();

        nomenclatorPostDto.setDenomination( nomBase.getName() );
        nomenclatorPostDto.setDescription( nomBase.getDescription() );
        nomenclatorPostDto.setActive( nomBase.isActive() );

        return nomenclatorPostDto;
    }

    @Override
    public void updateNomEmergencyCodeFromNomenclatorPostDto(NomenclatorPostDto dto, NomEmergencycodeEntity personEntity) {
        if ( dto == null ) {
            return;
        }

        personEntity.setName( dto.getDenomination() );
        personEntity.setDescription( dto.getDescription() );
        if ( dto.getActive() != null ) {
            personEntity.setActive( dto.getActive() );
        }
        if ( dto.getCode() != null ) {
            personEntity.setCode( dto.getCode() );
        }
    }
}
