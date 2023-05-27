package com.emergency.configuration.nomenclator.mapper;

import com.emergency.common.domain.entity.NomBase;
import com.emergency.configuration.nomenclator.domain.entity.NomEmergencycodeEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomHealthunitEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomMoviltypeEntity;
import com.emergency.configuration.nomenclator.dto.NomenclatorPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NomenclatorMapper {

    NomenclatorMapper INSTANCE = Mappers.getMapper(NomenclatorMapper.class );
    @Mapping(source = "denomination", target = "name")
    NomEmergencycodeEntity nomenclatorDtoToNomEmergencyEntity(NomenclatorPostDto nomenclatorDto);

    @Mapping(source = "denomination", target = "name")
    NomHealthunitEntity nomenclatorDtoToNomHealthunitEntity(NomenclatorPostDto nomenclatorDto);

    @Mapping(source = "denomination", target = "name")
    NomMoviltypeEntity nomenclatorDtoToNomMoviltypeEntity(NomenclatorPostDto nomenclatorDto);

    @Mapping(source = "name", target = "denomination")
    NomenclatorPostDto nomBaseToNomenclatorDto(NomBase nomBase);

    @Mapping(source = "denomination", target = "name")
    void updateNomEmergencyCodeFromNomenclatorPostDto(NomenclatorPostDto dto,@MappingTarget NomEmergencycodeEntity personEntity );




}
