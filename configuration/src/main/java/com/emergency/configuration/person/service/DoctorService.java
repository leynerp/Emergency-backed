package com.emergency.configuration.person.service;

import com.emergency.common.config.ResponsePagination;
import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.exception.DuplicateCodeException;
import com.emergency.configuration.person.domain.entity.DatAgentEntity;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.repository.DatDoctorRepository;
import com.emergency.configuration.person.domain.repository.DatPersonRepository;
import com.emergency.configuration.person.dto.AgentDto;
import com.emergency.configuration.person.dto.DoctorDto;
import com.emergency.configuration.person.exception.DuplicateMedicalRegistryException;
import com.emergency.configuration.person.mapper.PersonMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DoctorService extends PersonBaseServiceImpl<DatDoctorregistryEntity,Long>{

    private DatPersonRepository datPersonRepository;

    private DatDoctorRepository datDoctorRepository;
    @Autowired
    PersonMapper personMapper;
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
        if (obj.getPersonEntity().getNoIdentification()!=null){
            Optional<DatPersonEntity> personEntity=datPersonRepository.findByNoIdentificationIgnoreCase(obj.getPersonEntity().getNoIdentification());
            personEntity.ifPresent((p)-> {throw new DuplicateCodeException();});
        }
        if (obj.getMedicalRegistry()!=null){
            Optional<DatDoctorregistryEntity> datDoctorregistryEntity=datDoctorRepository.findByMedicalRegistryIgnoreCase(obj.getMedicalRegistry());
            datDoctorregistryEntity.ifPresent((p)-> {throw new DuplicateMedicalRegistryException();});
        }




    }
    public ResponsePagination<DoctorDto> getDoctors(int start, int limit) {
        ResponsePagination<DatDoctorregistryEntity> allDoctorEntity=this.findAll(start,limit);
        List<DoctorDto> listDoctortDto=personMapper.doctorEntityListToDoctorDtoList(allDoctorEntity.getData());
        ResponsePagination<DoctorDto> responseAllDto=new ResponsePagination<>(listDoctortDto,allDoctorEntity.getTotal_count());
        return responseAllDto;
    }
}
