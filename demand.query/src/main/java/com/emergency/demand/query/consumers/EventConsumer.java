package com.emergency.demand.query.consumers;

import com.emergency.common.events.EmergencyDemandCreatedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
    void consume(@Payload EmergencyDemandCreatedEvent event, Acknowledgment ack);

}
