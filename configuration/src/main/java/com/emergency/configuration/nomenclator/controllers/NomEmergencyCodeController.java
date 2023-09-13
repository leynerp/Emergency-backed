package com.emergency.configuration.nomenclator.controllers;


import com.emergency.common.config.InfoMessage;
import com.emergency.configuration.nomenclator.domain.entity.NomEmergencycodeEntity;
import com.emergency.configuration.nomenclator.service.NomEmergencyCodeServiceNom;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
@RestController
@RequestMapping(value = "/v1/nomenclatorec")
@AllArgsConstructor
public class NomEmergencyCodeController {
    @Autowired
    NomEmergencyCodeServiceNom emergencyCodeService;
    @Autowired
    MessageSource messageSource;


    @PostMapping()
    public ResponseEntity insertData(@RequestBody NomEmergencycodeEntity nomEmergencyCode) throws Exception {
        emergencyCodeService.insert(nomEmergencyCode);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.nomenclator.creation.success", null, Locale.getDefault())), HttpStatus.OK);
    }
    @GetMapping("/{start}/{limit}")
    public ResponseEntity getAll(@PathVariable("start") Integer start,@PathVariable("limit") Integer limit){
        return ResponseEntity.ok(emergencyCodeService.findAllData(start, limit));
    }
    @PatchMapping("/{id}")
    public ResponseEntity updatetData(@PathVariable("id") Long id, @RequestBody NomEmergencycodeEntity nomEmergencyCode) throws Exception {
        nomEmergencyCode.setId(id);
        emergencyCodeService.updateData(nomEmergencyCode,id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.nomenclator.update.success", null, Locale.getDefault())), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteData(@PathVariable("id") Long id ) {
        emergencyCodeService.deleteData(id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.nomenclator.delete.success", null, Locale.getDefault())), HttpStatus.OK);
    }

}
