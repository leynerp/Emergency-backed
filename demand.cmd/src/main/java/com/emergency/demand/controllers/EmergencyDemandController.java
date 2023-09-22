package com.emergency.demand.controllers;

import com.emergency.common.config.InfoMessage;
import com.emergency.common.commands.CreateEmergencyDemandCommand;
import com.emergency.common.commands.DeleteEmergencyDemandCommand;
import com.emergency.demand.commands.EmergencyDemandCommandDispatcher;
import com.emergency.common.commands.UpdateEmergencyDemandCommand;
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
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.demand.creation.success", null, Locale.getDefault())), HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<InfoMessage> updateCommand(@RequestBody UpdateEmergencyDemandCommand command){
        dispatcher.send(command);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.demand.update.success", null, Locale.getDefault())), HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<InfoMessage> deleteCommand(@RequestBody DeleteEmergencyDemandCommand command){
        dispatcher.send(command);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.demand.delete.success",null, Locale.getDefault())),HttpStatus.OK);

    }
}
