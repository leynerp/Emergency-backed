package com.emergency.demand.commands;

import com.emergency.common.config.DemandState;
import com.emergency.cqrs.core.comand.BaseCommand;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateEmergencyDemandCommand extends BaseCommand {
    private Integer idDemand;
    private LocalDateTime registryDate;
    private String emergency;
    private String address;
    private Integer respiratoryRate;
    private String bloodPressure;
    private Integer bodyTemperature;
    private Integer heartRate;
    private String patients ;
    private String doctor ;
    private String agent ;
    private String healthUnitDestin ;
    private String priority;
    private DemandState state;

}
