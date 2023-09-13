package com.emergency.demand.commands;

public interface CommandHandler {
    void handle (CreateEmergencyDemandCommand command);
    void handle (UpdateEmergencyDemandCommand command);
}
