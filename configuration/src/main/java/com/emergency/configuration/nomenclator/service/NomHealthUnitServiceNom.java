package com.emergency.configuration.nomenclator.service;


import com.emergency.configuration.nomenclator.domain.entity.NomHealthunitEntity;
import com.emergency.configuration.nomenclator.domain.repository.NomHealthUnitRepository;
import org.springframework.stereotype.Service;

@Service
public class NomHealthUnitServiceNom extends BaseServiceImplNom<NomHealthunitEntity,Long> {
    private NomHealthUnitRepository nomHealthUnitRepository;
    public NomHealthUnitServiceNom(NomHealthUnitRepository nomHealthUnitRepository) {
        super(nomHealthUnitRepository);

    }
    @Override
    public NomHealthunitEntity insertData(NomHealthunitEntity obj) {
        return super.insertData(obj);
    }

    @Override
    public NomHealthunitEntity updateData(NomHealthunitEntity obj, Long id) {
        return super.updateData(obj, id);
    }

    @Override
    public Boolean deleteData(Long id) {
        return super.deleteData(id);
    }
}
