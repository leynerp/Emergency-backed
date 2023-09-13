package com.emergency.configuration.nomenclator.domain.repository;

import com.emergency.common.domain.repository.NomBaseRepository;
import com.emergency.configuration.nomenclator.domain.entity.NomDocumentTypeEntity;
import com.emergency.configuration.nomenclator.domain.entity.NomHealthunitEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface NomDocumentTypeRepository extends NomBaseRepository<NomDocumentTypeEntity,Long> {
}
