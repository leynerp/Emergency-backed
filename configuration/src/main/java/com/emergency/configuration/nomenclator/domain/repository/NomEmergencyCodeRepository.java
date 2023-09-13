package com.emergency.configuration.nomenclator.domain.repository;

import com.emergency.common.domain.repository.NomBaseRepository;
import com.emergency.configuration.nomenclator.domain.entity.NomEmergencycodeEntity;
import com.emergency.configuration.nomenclator.dto.EmergencyCodeDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NomEmergencyCodeRepository extends NomBaseRepository<NomEmergencycodeEntity,Long> {
     Optional<NomEmergencycodeEntity> findFirstByCode(Integer code);

    @Query(name = "getAllEmergencyCode",nativeQuery = true)
   List<EmergencyCodeDto> findAllData(@Param("start") int start, @Param("limit") int limit);

}
