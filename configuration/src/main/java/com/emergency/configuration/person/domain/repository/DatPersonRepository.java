package com.emergency.configuration.person.domain.repository;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DatPersonRepository extends PersonBaseRepository<DatPersonEntity,Long> {
    Optional<DatPersonEntity> findByNoIdentificationIgnoreCase(String identification);
}
