package com.emergency.common.commands;

import com.emergency.common.config.DemandState;
import com.emergency.cqrs.core.command.BaseCommand;
import lombok.Data;

@Data
public class UpdateEmergencyDemandCommand extends BaseCommand {
    private Integer idDemand;
    private String priority;
    private DemandState state;

}
