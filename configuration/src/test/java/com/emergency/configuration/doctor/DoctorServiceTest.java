package com.emergency.configuration.doctor;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.repository.DatDoctorRepository;
import com.emergency.configuration.person.domain.repository.DatPersonRepository;
import com.emergency.configuration.person.service.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DatDoctorRepository datDoctorRepository;

    @Mock
    private DatPersonRepository datPersonRepository;

    @Mock
    protected PersonBaseRepository<DatDoctorregistryEntity,Integer> baseRepository;

    @InjectMocks
    private DoctorService doctorService;

    private DatDoctorregistryEntity doctor;


    @BeforeEach
    void buildDoctor(){
        DatPersonEntity datPersonEntity = DatPersonEntity.builder()
                .name("Leyner")
                .fLastname("Patterson")
                .secLastname("Tamayo")
                .noIdentification("99")
                .build();
        this.doctor = DatDoctorregistryEntity.builder()
                .personEntity(datPersonEntity)
                .medicalRegistry("7777")
                .build();
    }

    @DisplayName("Insert a doctor")
    @Test
    void insertDoctor(){
        //given
         //  given(datDoctorRepository.save(this.doctor)).willReturn(doctor);
       //when
        //DatDoctorregistryEntity doctorSave=this.doctorService.insertData(this.doctor);
       //then
       //assertEquals(doctorSave.getMedicalRegistry(),this.doctor.getMedicalRegistry());
    }

}
