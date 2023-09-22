package com.emergency.common.commands;

import com.emergency.common.config.DemandState;
import com.emergency.cqrs.core.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmergencyDemandCommand extends BaseCommand {
    private LocalDateTime registryDate;
    private String emergency;
    private String emergencyCode;
    private String address;
    private VitalSign vitalSign;
    private String patients ;
    private String doctor ;
    private String agent ;
    private String healthUnitDestin ;
    private String priority;
    private DemandState state;

}
