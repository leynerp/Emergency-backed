package com.emergency.demand.query.events;

import com.emergency.common.events.EmergencyDemandCreatedEvent;
import com.emergency.demand.query.domain.entity.DatEmergencyDemandEntity;
import com.emergency.demand.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyDemandEventHandler implements EventHandler{
    @Autowired
    QueryService queryService;

    @Override
    public void on(EmergencyDemandCreatedEvent event) {
        var newDemand= DatEmergencyDemandEntity.builder()
                        .demandDate(event.getData().getRegistryDate())
                        .emergency(event.getData().getEmergency())
                        .addres(event.getData().getAddress())
                        .respiratoryRate(event.getData().getVitalSign().getRespiratoryRate())
                        .bloodPressure(event.getData().getVitalSign().getBloodPressure())
                        .bodyTemperature(event.getData().getVitalSign().getBodyTemperature())
                        .heartRate(event.getData().getVitalSign().getHeartRate())
                        .patients(event.getData().getPatients())
                        .doctor(event.getData().getDoctor())
                        .agent(event.getData().getAgent())
                        .healthUnitDestin(event.getData().getHealthUnitDestin())
                        .priority(event.getData().getPriority())
                        .emergencyCode(event.getData().getEmergencyCode())
                        .user(event.getUser()).build();

        queryService.save(newDemand);
    }


}
