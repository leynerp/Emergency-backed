package com.emergency.configuration.person.controllers;


import com.emergency.common.config.InfoMessage;
import com.emergency.common.config.ResponsePagination;
import com.emergency.configuration.person.dto.DoctorDto;
import com.emergency.configuration.person.dto.ShipperDto;
import com.emergency.configuration.person.mapper.PersonMapper;
import com.emergency.configuration.person.service.DoctorService;
import com.emergency.configuration.person.service.ShiperService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(value = "/v1/persons/shipper")
@AllArgsConstructor
public class ShiperController {
    @Autowired
    ShiperService shipperService;
    @Autowired
    MessageSource messageSource;

    @Autowired
    PersonMapper personMapper;

    @GetMapping("/{start}/{limit}")
    public ResponsePagination<ShipperDto> getAll(@PathVariable("start") int start, @PathVariable("limit") int limit) {
        return shipperService.getShipper(start,limit);
    }
    @PostMapping()
    public ResponseEntity insertData(@RequestBody ShipperDto shipperDto) throws Exception {
        shipperService.insertData(personMapper.shipperDtoToDatShipperEntity(shipperDto));
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.shipper.creation.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateData(@PathVariable("id") Long id, @RequestBody ShipperDto shipperDto) throws Exception {
        shipperService.updateData(personMapper.shipperDtoToDatShipperEntity(shipperDto),id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.shipper.update.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteData(@PathVariable("id") Long id) throws Exception {
        shipperService.deleteData(id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.shipper.delete.success", null, Locale.getDefault())), HttpStatus.OK);
    }

}
