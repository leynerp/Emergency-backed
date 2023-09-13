package com.emergency.demand.commands;

import com.emergency.demand.service.EmergencyDemandCommandService;
import org.springframework.stereotype.Service;

@Service
public class EmergencyDemandCommandHandler implements CommandHandler{
    public EmergencyDemandCommandHandler(EmergencyDemandCommandService emergencyDemandCommandService) {
        this.emergencyDemandCommandService = emergencyDemandCommandService;
    }

    private EmergencyDemandCommandService emergencyDemandCommandService;
    @Override
    public void handle(CreateEmergencyDemandCommand command) {
        emergencyDemandCommandService.save(command);
    }

    @Override
    public void handle(UpdateEmergencyDemandCommand command) {

    }
}
