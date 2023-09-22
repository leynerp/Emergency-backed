package com.emergency.demand.query.service;

import com.emergency.demand.query.domain.entity.DatEmergencyDemandEntity;
import com.emergency.demand.query.domain.repository.EmergencyDemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyDemandQueryService implements QueryService<DatEmergencyDemandEntity>{

    @Autowired
    EmergencyDemandRepository demandRepository;
    @Override
    public void save(DatEmergencyDemandEntity demand) {
      demandRepository.save(demand);
    }
}
