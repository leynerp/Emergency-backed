package com.emergency.configuration.nomenclator.service;
import com.emergency.configuration.nomenclator.domain.entity.NomMoviltypeEntity;
import com.emergency.configuration.nomenclator.domain.repository.NomMovilTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class NomMovilTypeService extends BaseServiceImplNom<NomMoviltypeEntity,Long> {
    public NomMovilTypeService(NomMovilTypeRepository nomDocumentTypeRepository) {
        super(nomDocumentTypeRepository);

    }
    @Override
    public NomMoviltypeEntity insertData(NomMoviltypeEntity obj) {
        return super.insertData(obj);
    }

    @Override
    public NomMoviltypeEntity updateData(NomMoviltypeEntity obj, Long id) {
        return super.updateData(obj, id);
    }

    @Override
    public Boolean deleteData(Long id) {
        return super.deleteData(id);
    }
}
