package com.emergency.configuration.person.service;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.exception.DuplicateCodeException;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.repository.DatPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService extends PersonBaseServiceImpl<DatDoctorregistryEntity,Long>{
    @Autowired
    private DatPersonRepository datPersonRepository;

    public DoctorService(PersonBaseRepository<DatDoctorregistryEntity, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public DatDoctorregistryEntity insertData(DatDoctorregistryEntity obj) {
        Optional<DatPersonEntity> personEntity=datPersonRepository.findByNoIdentificationIgnoreCase(obj.getPersonEntity().getNoIdentification());
        personEntity.ifPresent((p)-> {throw new DuplicateCodeException();});
        return super.insertData(obj);
    }
}
