package com.emergency.demand.query.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.Integer;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "dat_emergencydemand", schema = "mod_emergency", catalog = "db_emergency")
public class DatEmergencyDemandEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idemergencydemand", nullable = false, precision = 0)
    private int idemergencydemand;
    @Basic
    @Column(name = "demand_date", nullable = false)
    private LocalDateTime demandDate;
    @Basic
    @Column(name = "emergency", nullable = false, length = 500)
    private String emergency;
    @Basic
    @Column(name = "addres", nullable = false, length = 500)
    private String addres;
   @Basic
    @Column(name = "respiratory_rate", nullable = false, precision = 0)
    private int respiratoryRate;
    @Basic
    @Column(name = "blood_pressure", nullable = true, length = 10)
    private String bloodPressure;
    @Basic
    @Column(name = "body_temperature", nullable = true, precision = 0)
    private Integer bodyTemperature;
    @Basic
    @Column(name = "heart_rate", nullable = true, precision = 0)
    private Integer heartRate;
    @Basic
    @Column(name = "patients", nullable = false, length = 255)
    private String patients;
    @Basic
    @Column(name = "doctor", nullable = false, length = 255)
    private String doctor;
     @Basic
    @Column(name = "agent", nullable = false, length = 255)
    private String agent;
    @Basic
    @Column(name = "health_unit_destin", nullable = false, length = 255)
    private String healthUnitDestin;
    @Basic
    @Column(name = "priority", nullable = false, length = 255)
    private String priority;
    @Basic
    @Column(name = "emergency_code", nullable = true, length = 500)
    private String emergencyCode;
    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    private String user;
}
