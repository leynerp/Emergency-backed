package com.emergency.configuration.person.service;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.exception.DuplicateCodeException;
import com.emergency.configuration.person.domain.entity.DatAgentEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.entity.DatAgentEntity;
import com.emergency.configuration.person.domain.repository.DatAgentRepository;
import com.emergency.configuration.person.domain.repository.DatPersonRepository;
import com.emergency.configuration.person.domain.repository.DatShipperRepository;
import com.emergency.configuration.person.exception.DuplicateMedicalRegistryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgentService extends PersonBaseServiceImpl<DatAgentEntity, Long> {
    @Autowired
    private DatPersonRepository datPersonRepository;
    @Autowired
    private DatAgentRepository datAgentRepository;

    public AgentService(PersonBaseRepository<DatAgentEntity, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public DatAgentEntity insertData(DatAgentEntity obj) {
        validateShipperData(obj);
        return super.insertData(obj);
    }

    @Override
    public DatAgentEntity updateData(DatAgentEntity obj, Long id) {
        validateShipperData(obj);
        obj.setIdAgent(id);
        obj.getPersonEntity().setIdperson(id);
        return super.updateData(obj, id);
    }

    private void validateShipperData(DatAgentEntity obj) {
        if (obj.getPersonEntity().getNoIdentification() != null) {
            Optional<DatPersonEntity> personEntity = datPersonRepository.findByNoIdentificationIgnoreCase(obj.getPersonEntity().getNoIdentification());
            personEntity.ifPresent((p) -> {
                throw new DuplicateCodeException();
            });
        }
        if (obj.getIdentificationNumber() != null) {
            Optional<DatAgentEntity> datAgent = datAgentRepository.findByIdentificationNumber(obj.getIdentificationNumber());
            datAgent.ifPresent((p) -> {
                throw new DuplicateMedicalRegistryException();
            });
        }


    }
}
