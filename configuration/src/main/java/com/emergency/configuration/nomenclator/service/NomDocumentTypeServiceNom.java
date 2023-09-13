package com.emergency.configuration.nomenclator.service;


import com.emergency.configuration.nomenclator.domain.entity.NomDocumentTypeEntity;
import com.emergency.configuration.nomenclator.domain.repository.NomDocumentTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class NomDocumentTypeServiceNom extends BaseServiceImplNom<NomDocumentTypeEntity,Long> {
    public NomDocumentTypeServiceNom(NomDocumentTypeRepository nomDocumentTypeRepository) {
        super(nomDocumentTypeRepository);

    }
    @Override
    public NomDocumentTypeEntity insertData(NomDocumentTypeEntity obj) {

        return super.insertData(obj);
    }

    @Override
    public NomDocumentTypeEntity updateData(NomDocumentTypeEntity obj, Long id) {
        return super.updateData(obj, id);
    }

    @Override
    public Boolean deleteData(Long id) {
        return super.deleteData(id);
    }
}
