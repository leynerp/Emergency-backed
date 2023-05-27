package com.emergency.configuration.nomenclator.service;

import com.emergency.common.domain.entity.NomBase;
import com.emergency.configuration.nomenclator.config.NomenclatorType;
import com.emergency.configuration.nomenclator.dto.NomenclatorPostDto;
import com.emergency.configuration.nomenclator.mapper.NomenclatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class FactoryService {
    @Autowired
    private ApplicationContext context;

    @Autowired
    NomenclatorMapper nomenclatorMapper;
    public BaseServiceImplNom getBeanByRef(String ref) throws ClassNotFoundException {

        switch (NomenclatorType.byRefIgnoreCase(ref).get()) {
            case ECODE :
                return context.getBean(NomEmergencyCodeServiceNom.class);
            case HUNIT:
                return context.getBean(NomHealthUnitServiceNom.class);
            default:
                throw new ClassNotFoundException("Not class defined for this reference");
        }
    }
    public Class<?> getEntityClassNameByRef(String ref) throws ClassNotFoundException {
        switch (NomenclatorType.byRefIgnoreCase(ref).get()) {
            case ECODE:
                return Class.forName("com.emergency.configuration.nomenclator.dto.NomenclatorPostDto");
            case HUNIT:
                return Class.forName("com.emergency.configuration.nomenclator.domain.entity.NomHealthunitEntity");
            default:
                throw new ClassNotFoundException("Not class defined for this reference");
        }
    }

    public NomBase getEntityMapperByRef(NomenclatorPostDto nomenclatorPostDto, String ref) throws ClassNotFoundException {
        switch (NomenclatorType.byRefIgnoreCase(ref).get()) {
            case ECODE:
                return  nomenclatorMapper.nomenclatorDtoToNomEmergencyEntity(nomenclatorPostDto);
            case HUNIT:
                return nomenclatorMapper.nomenclatorDtoToNomHealthunitEntity(nomenclatorPostDto);
            default:
                throw new ClassNotFoundException("Not class defined for this reference");
        }
    }

}



