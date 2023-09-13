package com.emergency.demand.events;

import com.emergency.cqrs.core.comand.BaseEvent;
import com.emergency.demand.commands.CreateEmergencyDemandCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyDemandCreatedEvent extends BaseEvent {
    private CreateEmergencyDemandCommand createCommand;

}
