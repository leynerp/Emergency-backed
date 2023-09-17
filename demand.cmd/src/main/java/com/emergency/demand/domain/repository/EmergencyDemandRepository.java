package com.emergency.demand.domain.repository;

import com.emergency.demand.domain.model.EmergencyDemandModel;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmergencyDemandRepository extends MongoRepository<EmergencyDemandModel,String> {

    @Aggregation(pipeline = {"{$match:{$expr:{ $and:[" +
            "{$eq: [{$year:'$registryDate'},{ $year: new Date()}] }," +
            "{$eq: [{$month: '$registryDate' }, { $month: new Date() }] }," +
            "{$eq: [{ $dayOfMonth: '$registryDate' }, { $dayOfMonth: new Date() }] }," +
            "{$eq: [{$trim: {input: { $toLower: '$patients'}, chars:' '}},{ $toLower: '?0' }] }" +
            " ]}}}"})
    Optional<List<EmergencyDemandModel>> getEmergencyDemandModelByPatients(String patients);

}
