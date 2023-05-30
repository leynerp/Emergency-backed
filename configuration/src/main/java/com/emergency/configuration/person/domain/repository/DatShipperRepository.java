package com.emergency.configuration.person.domain.repository;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatShipperEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DatShipperRepository extends PersonBaseRepository<DatShipperEntity,Long> {
    Optional<DatShipperEntity> findByRegistryIgnoreCase(String registry);
}
