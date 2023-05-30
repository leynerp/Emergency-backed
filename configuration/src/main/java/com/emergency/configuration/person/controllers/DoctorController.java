package com.emergency.configuration.person.controllers;


import com.emergency.common.config.InfoMessage;

import com.emergency.configuration.person.dto.DoctorDto;
import com.emergency.configuration.person.mapper.PersonMapper;
import com.emergency.configuration.person.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Locale;

@RestController
@RequestMapping(value = "/v1/persons/doctor")
@AllArgsConstructor
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    MessageSource messageSource;

    @Autowired
    PersonMapper personMapper;

    @PostMapping()
    public ResponseEntity insertData(@RequestBody DoctorDto doctorDto) throws Exception {
        doctorService.insertData(personMapper.doctorDtoToDatDoctorEntity(doctorDto));
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.doctor.creation.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateData(@PathVariable("id") Long id, @RequestBody DoctorDto doctorDto) throws Exception {
        doctorService.updateData(personMapper.doctorDtoToDatDoctorEntity(doctorDto),id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.doctor.update.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteData(@PathVariable("id") Long id) throws Exception {
        doctorService.deleteData(id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.doctor.delete.success", null, Locale.getDefault())), HttpStatus.OK);
    }

}
