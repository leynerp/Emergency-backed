package com.emergency.demand.events;

import com.emergency.cqrs.core.command.BaseEvent;
import com.emergency.cqrs.core.command.EventFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
@Service
public class EventFactoryDemand implements EventFactory {
   private KafkaTemplate <String,BaseEvent<?>> kafkaTemplate;

    public EventFactoryDemand(KafkaTemplate<String, BaseEvent<?>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void produce(String topic, BaseEvent event)
    {
        ListenableFuture<SendResult<String, BaseEvent<?>>> future = this.kafkaTemplate.send(topic,event);
        future.completable().whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + event.getHandleDate() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        event.getHandleDate() + "] due to : " + ex.getMessage());
            }
        });
    }
}
