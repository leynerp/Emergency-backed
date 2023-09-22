package com.emergency.demand.query.consumers;

import com.emergency.common.events.EmergencyDemandCreatedEvent;
import com.emergency.demand.query.events.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class EmergencyDemandEventConsumer implements EventConsumer{

    @Autowired
    private EventHandler eventHandler;

    @KafkaListener(topics = "${kafka.topic.event.create}", groupId = "${kafka.group_id}")
    @Override
    public void consume(EmergencyDemandCreatedEvent event,Acknowledgment ack) {
         eventHandler.on(event);
         ack.acknowledge();
    }
}
