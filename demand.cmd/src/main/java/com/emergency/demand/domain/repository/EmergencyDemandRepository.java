package com.emergency.demand.domain.repository;

import com.emergency.demand.domain.model.EmergencyDemandModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmergencyDemandRepository extends MongoRepository<EmergencyDemandModel,String> {

    @Query("{ 'name' : { $regex: ?0 } }")
    Optional<List<EmergencyDemandModel>> getEmergencyDemandModelByPatientsAndHealthUnitDestin();

}
