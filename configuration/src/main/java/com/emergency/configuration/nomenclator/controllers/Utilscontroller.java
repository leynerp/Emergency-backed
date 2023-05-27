package com.emergency.configuration.nomenclator.controllers;

import com.emergency.common.domain.entity.NomBase;
import com.emergency.configuration.nomenclator.service.BaseServiceImplNom;
import com.emergency.configuration.nomenclator.dto.NomenclatorPostDto;
import com.emergency.configuration.nomenclator.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@Service
public class Utilscontroller {
   @Autowired
    FactoryService factoryService;
    BaseServiceImplNom objService ;
    Class<?> nameClassService ;
    Class<?> classEntity ;
    String ref;
    public void setData(String ref) throws ClassNotFoundException {
        this.ref=ref;
        this.objService = factoryService.getBeanByRef(ref);
        this.nameClassService = this.objService.getClass();
        this.classEntity = factoryService.getEntityClassNameByRef(ref);
    }
    public void insertData(NomenclatorPostDto nomenclatorPostDto) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        NomBase nomBase=factoryService.getEntityMapperByRef(nomenclatorPostDto,this.ref);
        Method addMethod = nameClassService.getMethod("insertData", classEntity);
        addMethod.invoke(objService, nomBase);
    }
    public void updateData(Long id,NomenclatorPostDto nomenclatorPostDto) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        NomBase nomBase=factoryService.getEntityMapperByRef(nomenclatorPostDto,this.ref);
        Method updMethod = this.nameClassService.getMethod("updateData", classEntity,Long.class);
        nomBase.setId(id);
        updMethod.invoke(objService, nomBase,id);
    }
    public void deleteData(Long id) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method delMethod = this.nameClassService.getMethod("deleteData",Long.class);
        delMethod.invoke(objService,id);
    }

}
