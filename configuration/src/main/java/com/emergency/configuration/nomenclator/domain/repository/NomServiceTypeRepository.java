package com.emergency.configuration.nomenclator.domain.repository;

import com.emergency.common.domain.repository.NomBaseRepository;
import com.emergency.configuration.nomenclator.domain.entity.NomMoviltypeEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomServicetypeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface NomServiceTypeRepository extends NomBaseRepository<NomServicetypeEntity,Long> {
}
