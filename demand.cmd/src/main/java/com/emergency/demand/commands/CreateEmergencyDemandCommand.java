package com.emergency.demand.commands;

import com.emergency.common.config.DemandState;
import com.emergency.cqrs.core.comand.BaseCommand;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class CreateEmergencyDemandCommand extends BaseCommand {
    private LocalDateTime registryDate;
    private String emergency;
    private String address;
    private VitalSign vitalSign;
    private String patients ;
    private String doctor ;
    private String agent ;
    private String healthUnitDestin ;
    private String priority;
    private DemandState state;

}
