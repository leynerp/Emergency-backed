package com.emergency.configuration.nomenclator.controllers;

import com.emergency.common.config.InfoMessage;
import com.emergency.configuration.nomenclator.service.BaseServiceImplNom;
import com.emergency.configuration.nomenclator.dto.NomenclatorPostDto;
import com.emergency.configuration.nomenclator.service.FactoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

@RestController
@RequestMapping(value = "/v1/nomenclator")
@AllArgsConstructor
public class NomenclatorController {
    @Autowired
    FactoryService factoryService;

    @Autowired
    Utilscontroller utilscontroller;
    @Autowired
    MessageSource messageSource;

    @GetMapping("/{ref}/{start}/{limit}")
    public ResponseEntity getAll(@PathVariable("start") Integer start, @PathVariable("limit") Integer limit, @PathVariable("ref") String ref) throws ClassNotFoundException {
        BaseServiceImplNom objService = factoryService.getBeanByRef(ref);
        return ResponseEntity.ok(objService.findAll(start, limit));
    }

    @PostMapping("/{ref}")
    public ResponseEntity insertData(@PathVariable("ref") String ref, @RequestBody NomenclatorPostDto nomenclatorPostDto) throws Exception {
        utilscontroller.setData(ref);
        utilscontroller.insertData(nomenclatorPostDto);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.nomenclator.creation.success", null, Locale.getDefault())), HttpStatus.OK);
    }
    @PatchMapping("/{ref}/{id}")
    public ResponseEntity updatetData(@PathVariable("ref") String ref,@PathVariable("id") Long id, @RequestBody NomenclatorPostDto nomenclatorPostDto) throws Exception {
        utilscontroller.setData(ref);
        utilscontroller.updateData(id,nomenclatorPostDto);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.nomenclator.update.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @DeleteMapping("/{ref}/{id}")
    public ResponseEntity deleteData(@PathVariable("ref") String ref,@PathVariable("id") Long id) throws Exception {
        utilscontroller.setData(ref);
        utilscontroller.deleteData(id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.nomenclator.delete.success", null, Locale.getDefault())), HttpStatus.OK);
    }



}
