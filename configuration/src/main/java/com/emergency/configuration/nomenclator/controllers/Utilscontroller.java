package com.emergency.configuration.nomenclator.controllers;

import com.emergency.common.domain.entity.NomBase;
import com.emergency.configuration.nomenclator.domain.entity.NomDocumentTypeEntity;
import com.emergency.configuration.nomenclator.service.BaseServiceImplNom;
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
    public void insertData(NomBase nomBase) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method addMethod = nameClassService.getMethod("insertData", this.classEntity);
        addMethod.invoke(this.objService, this.factoryService.getObjectMapped(nomBase,this.ref));
    }
    public void updateData(Long id,NomBase nomBase) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method updMethod = this.nameClassService.getMethod("updateData", this.classEntity,Long.class);
        updMethod.invoke(this.objService, this.factoryService.getObjectMapped(nomBase,this.ref),id);
    }
    public void deleteData(Long id) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method delMethod = this.nameClassService.getMethod("deleteData",Long.class);
        delMethod.invoke(this.objService,id);
    }

}
