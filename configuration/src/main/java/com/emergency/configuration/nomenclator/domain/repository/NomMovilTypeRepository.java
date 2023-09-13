package com.emergency.configuration.nomenclator.domain.repository;

import com.emergency.common.domain.repository.NomBaseRepository;
import com.emergency.configuration.nomenclator.domain.entity.NomMoviltypeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface NomMovilTypeRepository extends NomBaseRepository<NomMoviltypeEntity,Long> {
}
