package com.emergency.configuration.person.domain.repository;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.person.domain.entity.DatAgentEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DatAgentRepository extends PersonBaseRepository<DatAgentEntity,Long> {
    Optional<DatAgentEntity> findByAgentNumber(Long registry);
}
