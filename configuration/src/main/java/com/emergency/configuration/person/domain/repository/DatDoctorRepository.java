package com.emergency.configuration.person.domain.repository;

import com.emergency.common.domain.repository.PersonBaseRepository;


import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DatDoctorRepository extends PersonBaseRepository<DatDoctorregistryEntity,Long> {
    Optional<DatDoctorregistryEntity> findByMedicalRegistryIgnoreCase(String medicalRegistry);

}
