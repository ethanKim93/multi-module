package org.sample.adapter.port.out.messageQue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestProducer implements MqProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMqMessage(String queueName, String message) {
        log.info("Send Queue Name:" + queueName + ", Message : " + message);
        rabbitTemplate.convertAndSend(queueName, message);
    }

}