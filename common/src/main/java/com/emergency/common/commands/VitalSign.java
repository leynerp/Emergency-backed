package com.emergency.common.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSign {
    private Integer respiratoryRate;
    private String bloodPressure;
    private Integer bodyTemperature;
    private Integer heartRate;
}
