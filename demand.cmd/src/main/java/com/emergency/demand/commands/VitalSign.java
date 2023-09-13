package com.emergency.demand.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VitalSign {
    private Integer respiratoryRate;
    private String bloodPressure;
    private Integer bodyTemperature;
    private Integer heartRate;
}
