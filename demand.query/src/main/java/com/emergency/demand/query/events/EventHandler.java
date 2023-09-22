package com.emergency.demand.query.events;

import com.emergency.common.events.EmergencyDemandCreatedEvent;

public interface EventHandler {
    void on(EmergencyDemandCreatedEvent event);
}
