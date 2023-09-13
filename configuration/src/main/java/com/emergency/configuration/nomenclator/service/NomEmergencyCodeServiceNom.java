package com.emergency.configuration.nomenclator.service;

import com.emergency.common.config.ResponsePagination;
import com.emergency.common.domain.entity.NomBase;
import com.emergency.configuration.exception.DuplicateCodeException;
import com.emergency.configuration.nomenclator.domain.entity.NomEmergencycodeEntity;
import com.emergency.configuration.nomenclator.domain.repository.NomEmergencyCodeRepository;

import com.emergency.configuration.nomenclator.dto.EmergencyCodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NomEmergencyCodeServiceNom extends BaseServiceImplNom<NomEmergencycodeEntity,Long> {

    @Autowired
    private NomEmergencyCodeRepository nomEmergencyCodeRepo;
    public NomEmergencyCodeServiceNom(NomEmergencyCodeRepository nomEmergencyCodeRepository) {
        super(nomEmergencyCodeRepository);
    }

    public void insert(NomEmergencycodeEntity nomEmergencyCode) {
        Optional<NomEmergencycodeEntity> findByCode= nomEmergencyCodeRepo.findFirstByCode(nomEmergencyCode.getCode());
        findByCode.ifPresent((dat)-> {throw new DuplicateCodeException();});
        this.insertData(nomEmergencyCode);
    }


    public ResponsePagination<EmergencyCodeDto> findAllData(Integer start, Integer limit) {
        try {
            List<EmergencyCodeDto> data= nomEmergencyCodeRepo.findAllData(start,limit);
            Long countResgistry=nomEmergencyCodeRepo.count();
            return new ResponsePagination<>(data, countResgistry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NomEmergencycodeEntity updateData(NomEmergencycodeEntity obj, Long id) {
        Optional<NomEmergencycodeEntity> findByCode= nomEmergencyCodeRepo.findFirstByCode(obj.getCode());
        findByCode.ifPresent((dat)-> {throw new DuplicateCodeException();});
        return super.updateData(obj, id);
    }

    @Override
    public Boolean deleteData(Long id) {
        return super.deleteData(id);
    }


}
