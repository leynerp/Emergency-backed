package com.emergency.demand.query.domain.repository;

import com.emergency.demand.query.domain.entity.DatEmergencyDemandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyDemandRepository extends JpaRepository<DatEmergencyDemandEntity,Integer> {
}
