package com.emergency.demand.domain.model;

import com.emergency.common.config.DemandState;
import com.emergency.demand.commands.VitalSign;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document(collection = "demand")
@Data
@Builder
public class EmergencyDemandModel {
    @Id private String id;
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
