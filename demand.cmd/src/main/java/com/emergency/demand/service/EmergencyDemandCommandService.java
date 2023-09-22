package com.emergency.demand.service;
import com.emergency.cqrs.core.command.BaseCommand;
import com.emergency.cqrs.core.command.CommandStore;
import com.emergency.cqrs.core.command.EventFactory;
import com.emergency.common.commands.CreateEmergencyDemandCommand;
import com.emergency.common.commands.UpdateEmergencyDemandCommand;
import com.emergency.demand.domain.model.EmergencyDemandModel;
import com.emergency.demand.domain.repository.EmergencyDemandRepository;
import com.emergency.common.events.EmergencyDemandCreatedEvent;
import com.emergency.demand.exception.DemandNotFoundException;
import com.emergency.demand.exception.DuplicateDemandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmergencyDemandCommandService implements CommandStore {

    @Autowired
    EmergencyDemandRepository emergencyDemandRepository;
    @Autowired
    EventFactory eventFactory;
    @Override
    public <T extends BaseCommand> void save(T command) {
        CreateEmergencyDemandCommand insertCommand=(CreateEmergencyDemandCommand)command;
        var demand=emergencyDemandRepository.getEmergencyDemandModelByPatients(insertCommand.getPatients());
        if (demand.isPresent() && demand.get().size()!=0){
            throw new  DuplicateDemandException();
        }
        var user="leyner";//TODO replace this for the logic that provides the user
        var result=emergencyDemandRepository.save(EmergencyDemandModel.builder()
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
                .emergencyCode(insertCommand.getEmergencyCode())
                .user(user)
                .build());

        if (!result.getId().isEmpty()){
            var emergencyDemandCreateEvent=new EmergencyDemandCreatedEvent();
            insertCommand.setRegistryDate(result.getRegistryDate());
            emergencyDemandCreateEvent.setData(insertCommand);
            emergencyDemandCreateEvent.setHandleDate(LocalDateTime.now());
            emergencyDemandCreateEvent.setUser(user);
            eventFactory.produce(emergencyDemandCreateEvent.getClass().getSimpleName(),emergencyDemandCreateEvent);
        }
    }

    @Override
    public <T extends BaseCommand> void update(T command)  {
        Optional<EmergencyDemandModel> demandUpdate=emergencyDemandRepository.findById(command.getId());
        if (demandUpdate.isPresent()){
            UpdateEmergencyDemandCommand updateCommand=(UpdateEmergencyDemandCommand)command;
            demandUpdate.get().setState(updateCommand.getState());
            demandUpdate.get().setPriority(updateCommand.getPriority());
            emergencyDemandRepository.save(demandUpdate.get());
        }else
            throw new DemandNotFoundException();
    }

    @Override
    public <T extends BaseCommand> List<T> getCommands(String criteria) {
        return null;
    }

    @Override
    public <T extends BaseCommand> void delete(T command) {
        Optional<EmergencyDemandModel> demandDelete=emergencyDemandRepository.findById(command.getId());
        if (demandDelete.isPresent()){
            emergencyDemandRepository.delete(demandDelete.get());
        }else
            throw new DemandNotFoundException();
    }
}
