package com.emergency.demand.commands;

import com.emergency.common.commands.CreateEmergencyDemandCommand;
import com.emergency.common.commands.DeleteEmergencyDemandCommand;
import com.emergency.common.commands.UpdateEmergencyDemandCommand;

public interface CommandHandler {
    void handle (CreateEmergencyDemandCommand command);
    void handle (UpdateEmergencyDemandCommand command);
    void handle (DeleteEmergencyDemandCommand command);
}
