package com.emergency.configuration.doctor;

import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.repository.DatDoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorRespositoryTest {
    @Autowired
    private DatDoctorRepository datDoctorRepository;


    @BeforeEach
    void separeteTest(){
        System.out.println("--------------------------------------------------------------------");
    }

    @Test
    //@Commit
    void saveDoctorTest() {
        //given
        DatPersonEntity datPersonEntity = DatPersonEntity.builder()
                .name("Leyner")
                .fLastname("Patterson")
                .secLastname("Tamayo")
                .noIdentification("99")
                .build();
        DatDoctorregistryEntity datDoctorregistryEntity = DatDoctorregistryEntity.builder()
                .personEntity(datPersonEntity)
                .medicalRegistry("7777")
                .build();
        //when
         DatDoctorregistryEntity doctorSave= datDoctorRepository.save(datDoctorregistryEntity);
        //then
        assertThat(doctorSave).isNotNull();

        assertThat(doctorSave.getIdDoctor()).isGreaterThan(0);

    }

    @Test
    void listDoctorTest() {
        //given
        List<DatDoctorregistryEntity> listDoctor=datDoctorRepository.findAll();
        //then
        assertNotNull(listDoctor);
  }
}
