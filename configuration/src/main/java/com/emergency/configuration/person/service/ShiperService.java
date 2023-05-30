package com.emergency.configuration.person.service;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.exception.DuplicateCodeException;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.entity.DatShipperEntity;
import com.emergency.configuration.person.domain.repository.DatDoctorRepository;
import com.emergency.configuration.person.domain.repository.DatPersonRepository;
import com.emergency.configuration.person.domain.repository.DatShipperRepository;
import com.emergency.configuration.person.exception.DuplicateMedicalRegistryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShiperService extends PersonBaseServiceImpl<DatShipperEntity,Long>{
    @Autowired
    private DatPersonRepository datPersonRepository;
    @Autowired
    private DatShipperRepository datShipperRepository;

    public ShiperService(PersonBaseRepository<DatShipperEntity, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public DatShipperEntity insertData(DatShipperEntity obj) {
        validateShipperData(obj);
        return super.insertData(obj);
    }

    @Override
    public DatShipperEntity updateData(DatShipperEntity obj, Long id) {
        validateShipperData(obj);
        obj.setIdShipper(id);
        obj.getPersonEntity().setIdperson(id);
        return super.updateData(obj, id);
    }

    private void validateShipperData(DatShipperEntity obj) {
        if (obj.getPersonEntity().getNoIdentification()!=null){
            Optional<DatPersonEntity> personEntity=datPersonRepository.findByNoIdentificationIgnoreCase(obj.getPersonEntity().getNoIdentification());
            personEntity.ifPresent((p)-> {throw new DuplicateCodeException();});
        }
        if (obj.getRegistry()!=null){
            Optional<DatShipperEntity> datShipperEntity=datShipperRepository.findByRegistryIgnoreCase(obj.getRegistry());
            datShipperEntity.ifPresent((p)-> {throw new DuplicateMedicalRegistryException();});
        }




    }
}
