package com.emergency.common.events;
import com.emergency.common.commands.CreateEmergencyDemandCommand;
import com.emergency.cqrs.core.command.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmergencyDemandCreatedEvent extends BaseEvent<CreateEmergencyDemandCommand> {

}
