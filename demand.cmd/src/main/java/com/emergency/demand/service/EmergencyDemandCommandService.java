package com.emergency.demand.service;

import com.emergency.common.config.DemandState;
import com.emergency.cqrs.core.comand.BaseCommand;
import com.emergency.cqrs.core.comand.CommandStore;
import com.emergency.demand.commands.CreateEmergencyDemandCommand;
import com.emergency.demand.commands.VitalSign;
import com.emergency.demand.domain.model.EmergencyDemandModel;
import com.emergency.demand.domain.repository.EmergencyDemandRepository;
import com.emergency.demand.exception.DuplicateDemandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class EmergencyDemandCommandService implements CommandStore {

    @Autowired
    EmergencyDemandRepository emergencyDemandRepository;
    @Override
    public <T extends BaseCommand> void save(T command) {
        CreateEmergencyDemandCommand insertCommand=(CreateEmergencyDemandCommand)command;
        var demand=emergencyDemandRepository.getEmergencyDemandModelByPatients(insertCommand.getPatients());
        if (demand.isPresent() && demand.get().size()!=0){
            throw new  DuplicateDemandException();
        }
        emergencyDemandRepository.save(EmergencyDemandModel.builder()
                .agent(insertCommand.getAgent())
                .address(insertCommand.getAddress())
                .state(insertCommand.getState())
                .doctor(insertCommand.getDoctor())
                .patients(insertCommand.getPatients())
                .healthUnitDestin(insertCommand.getHealthUnitDestin())
                .priority(insertCommand.getPriority())
                .vitalSign(insertCommand.getVitalSign())
                .registryDate(LocalDateTime.now())
                .emergency(insertCommand.getEmergency())
                .build());
    }

    @Override
    public <T extends BaseCommand> List<T> getCommands(String criteria) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
