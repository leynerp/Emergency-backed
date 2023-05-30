package com.emergency.configuration.person.controllers;


import com.emergency.common.config.InfoMessage;
import com.emergency.configuration.person.dto.AgentDto;
import com.emergency.configuration.person.mapper.PersonMapper;
import com.emergency.configuration.person.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(value = "/v1/persons/agent")
public class AgentController {
    @Autowired
    AgentService agentService;
    @Autowired
    MessageSource messageSource;

    @Autowired
    PersonMapper personMapper;

    @PostMapping()
    public ResponseEntity insertData(@RequestBody AgentDto agentDto) throws Exception {
        agentService.insertData(personMapper.agentDtoToDatAgentEntity(agentDto));
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.agent.creation.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateData(@PathVariable("id") Long id, @RequestBody AgentDto agentDto) throws Exception {
        agentService.updateData(personMapper.agentDtoToDatAgentEntity(agentDto),id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.agent.update.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteData(@PathVariable("id") Long id) throws Exception {
        agentService.deleteData(id);
        return new ResponseEntity(new InfoMessage(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.agent.delete.success", null, Locale.getDefault())), HttpStatus.OK);
    }

}
