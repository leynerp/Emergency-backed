package com.emergency.configuration.nomenclator.service;
import com.emergency.configuration.nomenclator.domain.entity.NomServicetypeEntity;
import com.emergency.configuration.nomenclator.domain.repository.NomMovilTypeRepository;
import com.emergency.configuration.nomenclator.domain.repository.NomServiceTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class NomTypeService extends BaseServiceImplNom<NomServicetypeEntity,Long> {
    public NomTypeService(NomServiceTypeRepository nomServiceTypeRepository) {
        super(nomServiceTypeRepository);

    }
    @Override
    public NomServicetypeEntity insertData(NomServicetypeEntity obj) {
        return super.insertData(obj);
    }

    @Override
    public NomServicetypeEntity updateData(NomServicetypeEntity obj, Long id) {
        return super.updateData(obj, id);
    }

    @Override
    public Boolean deleteData(Long id) {
        return super.deleteData(id);
    }
}
