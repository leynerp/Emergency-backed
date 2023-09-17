package com.emergency.demand.controllers;

import com.emergency.common.config.InfoMessage;
import com.emergency.demand.commands.CreateEmergencyDemandCommand;
import com.emergency.demand.commands.EmergencyDemandCommandDispatcher;
import com.emergency.demand.service.EmergencyDemandCommandService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(path = "/api/v1/demands")
@AllArgsConstructor
public class EmergencyDemandController {
    private MessageSource messageSource;
    private EmergencyDemandCommandDispatcher dispatcher;
    @PostMapping()
    public ResponseEntity<InfoMessage> saveCommand(@RequestBody CreateEmergencyDemandCommand command){
        dispatcher.send(command);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.demand.creation.success", null, Locale.getDefault())), HttpStatus.OK);    }
}
