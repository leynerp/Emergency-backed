package com.emergency.configuration.nomenclator.service;

import com.emergency.configuration.exception.DuplicateCodeException;
import com.emergency.configuration.nomenclator.domain.entity.NomEmergencycodeEntity;
import com.emergency.configuration.nomenclator.domain.repository.NomEmergencyCodeRepository;
import com.emergency.configuration.nomenclator.dto.NomenclatorPostDto;

import com.emergency.configuration.nomenclator.mapper.NomenclatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class NomEmergencyCodeServiceNom extends BaseServiceImplNom<NomEmergencycodeEntity,Long> {
    @Autowired
    NomenclatorMapper nomenclatorMapper;
    @Autowired
    private NomEmergencyCodeRepository nomEmergencyCodeRepo;
    private NomEmergencyCodeRepository nomEmergencyCodeRepository;
    public NomEmergencyCodeServiceNom(NomEmergencyCodeRepository nomEmergencyCodeRepository) {
        super(nomEmergencyCodeRepository);
    }

    public void insert(NomenclatorPostDto nomenclatorPostDto) {
        NomEmergencycodeEntity nomEmergencycodeEntity=nomenclatorMapper.nomenclatorDtoToNomEmergencyEntity(nomenclatorPostDto);
        Optional<NomEmergencycodeEntity> findByCode= nomEmergencyCodeRepo.findFirstByCode(nomenclatorPostDto.getCode());
        findByCode.ifPresent((dat)-> {throw new DuplicateCodeException();});
        insertData(nomEmergencycodeEntity);
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
