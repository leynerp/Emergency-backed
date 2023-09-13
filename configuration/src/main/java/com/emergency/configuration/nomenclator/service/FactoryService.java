package com.emergency.configuration.nomenclator.service;

import com.emergency.common.domain.entity.NomBase;
import com.emergency.configuration.nomenclator.config.NomenclatorType;
import com.emergency.configuration.nomenclator.domain.entity.NomDocumentTypeEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomHealthunitEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomMoviltypeEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomServicetypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class FactoryService {
    @Autowired
    private ApplicationContext context;

    private static final Map<NomenclatorType, Class<?>> beanMappings = new HashMap<>();
    private static final Map<NomenclatorType, Class<?>> entityMappings = new HashMap<>();

    static {
        beanMappings.put(NomenclatorType.ECODE, NomEmergencyCodeServiceNom.class);
        beanMappings.put(NomenclatorType.HUNIT, NomHealthUnitServiceNom.class);
        beanMappings.put(NomenclatorType.DOCUMENTTYPE, NomDocumentTypeServiceNom.class);
        beanMappings.put(NomenclatorType.MOVILTYPE, NomMovilTypeService.class);
        beanMappings.put(NomenclatorType.SERVICETYPE, NomTypeService.class);

        try {
            entityMappings.put(NomenclatorType.HUNIT, Class.forName("com.emergency.configuration.nomenclator.domain.entity.NomHealthunitEntity"));
            entityMappings.put(NomenclatorType.DOCUMENTTYPE, Class.forName("com.emergency.configuration.nomenclator.domain.entity.NomDocumentTypeEntity"));
            entityMappings.put(NomenclatorType.MOVILTYPE, Class.forName("com.emergency.configuration.nomenclator.domain.entity.NomMoviltypeEntity"));
            entityMappings.put(NomenclatorType.SERVICETYPE, Class.forName("com.emergency.configuration.nomenclator.domain.entity.NomServicetypeEntity"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public BaseServiceImplNom getBeanByRef(String ref) throws ClassNotFoundException {
        NomenclatorType type = NomenclatorType.byRefIgnoreCase(ref).get();
        Class<?> beanClass = beanMappings.get(type);
        if (beanClass == null) {
            throw new ClassNotFoundException("Not class defined for this reference");
        }
        return (BaseServiceImplNom) context.getBean(beanClass);
    }

    public Class<?> getEntityClassNameByRef(String ref) throws ClassNotFoundException {
        NomenclatorType type = NomenclatorType.byRefIgnoreCase(ref).get();
        Class<?> entityClass = entityMappings.get(type);
        if (entityClass == null) {
            throw new ClassNotFoundException("Not class defined for this reference");
        }
        return entityClass;
    }

    public NomBase getObjectMapped(NomBase obj, String ref) throws ClassNotFoundException {
        NomenclatorType type = NomenclatorType.byRefIgnoreCase(ref).get();
        switch (type) {
            case HUNIT:
                NomHealthunitEntity objHealUnitEntity = new NomHealthunitEntity();
                objHealUnitEntity.setName(obj.getName());
                objHealUnitEntity.setDescription(obj.getDescription());
                objHealUnitEntity.setActive(obj.isActive());
                return objHealUnitEntity;
            case DOCUMENTTYPE:
                NomDocumentTypeEntity objTypeDocEntity = new NomDocumentTypeEntity();
                objTypeDocEntity.setName(obj.getName());
                objTypeDocEntity.setDescription(obj.getDescription());
                objTypeDocEntity.setActive(obj.isActive());
                return objTypeDocEntity;
            case MOVILTYPE:
                NomMoviltypeEntity objMovilTypeEntity = new NomMoviltypeEntity();
                objMovilTypeEntity.setName(obj.getName());
                objMovilTypeEntity.setDescription(obj.getDescription());
                objMovilTypeEntity.setActive(obj.isActive());
                return objMovilTypeEntity;
            case SERVICETYPE:
                NomServicetypeEntity objServiceTypeEntity = new NomServicetypeEntity();
                objServiceTypeEntity.setName(obj.getName());
                objServiceTypeEntity.setDescription(obj.getDescription());
                objServiceTypeEntity.setActive(obj.isActive());
                return objServiceTypeEntity;
            default:
                throw new ClassNotFoundException("Not class defined for this reference");
        }
    }
}