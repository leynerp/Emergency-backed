package com.emergency.configuration.nomenclator.domain.repository;

import com.emergency.common.domain.repository.NomBaseRepository;
import com.emergency.configuration.nomenclator.domain.entity.NomEmergencycodeEntity;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface NomEmergencyCodeRepository extends NomBaseRepository<NomEmergencycodeEntity,Long> {
     Optional<NomEmergencycodeEntity> findFirstByCode(Integer code);

}
