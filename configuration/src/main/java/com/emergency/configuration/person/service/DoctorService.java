package com.emergency.configuration.person.service;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.exception.DuplicateCodeException;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.repository.DatDoctorRepository;
import com.emergency.configuration.person.domain.repository.DatPersonRepository;
import com.emergency.configuration.person.exception.DuplicateMedicalRegistryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService extends PersonBaseServiceImpl<DatDoctorregistryEntity,Long>{
    @Autowired
    private DatPersonRepository datPersonRepository;
    @Autowired
    private DatDoctorRepository datDoctorRepository;

    public DoctorService(PersonBaseRepository<DatDoctorregistryEntity, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public DatDoctorregistryEntity insertData(DatDoctorregistryEntity obj) {
        validateDoctorData(obj);
        return super.insertData(obj);
    }

    @Override
    public DatDoctorregistryEntity updateData(DatDoctorregistryEntity obj, Long id) {
        validateDoctorData(obj);
        obj.setIdDoctor(id);
        obj.getPersonEntity().setIdperson(id);
        return super.updateData(obj, id);
    }

    private void validateDoctorData(DatDoctorregistryEntity obj) {
        if (obj.getIdDoctor()!=null){
            Optional<DatPersonEntity> personEntity=datPersonRepository.findByNoIdentificationIgnoreCase(obj.getPersonEntity().getNoIdentification());
            personEntity.ifPresent((p)-> {throw new DuplicateCodeException();});
        }
        if (obj.getMedicalRegistry()!=null){
            Optional<DatDoctorregistryEntity> datDoctorregistryEntity=datDoctorRepository.findByMedicalRegistryIgnoreCase(obj.getMedicalRegistry());
            datDoctorregistryEntity.ifPresent((p)-> {throw new DuplicateMedicalRegistryException();});
        }




    }
}
