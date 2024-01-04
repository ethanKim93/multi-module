package org.sample.adapter.port.in.mq;//package com.mirero.ics.api.global.connectivity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sample.adapter.port.out.file.FileWriter;
import org.sample.adapter.port.out.messageQue.MqProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Consumer;


@Slf4j
@Component
@RequiredArgsConstructor
public class TestConsumer {
    private static FileWriter fileWriter = new FileWriter();
    private final MqProducer mqProducer;

    @RabbitListener(queues = "TEST_BP")
    public void receiveMessage(final String message) {
        log.info("Receive TEST_BP");
        log.info(message.toString());
        mqProducer.sendMqMessage("DL_QUEUE_IN", "aa");
//        fileWriter.writeResultFile("C:\\WATCHER_TEST\\DL_TEST\\result.txt");
    }

    @RabbitListener(queues = "TEST_EVEN")
    public void receiveEvenMessage(final String message) {
        log.info("Receive TEST_EVEN");
        log.info(message.toString());
        mqProducer.sendMqMessage("DL_QUEUE_IN", "aa");

//        fileWriter.writeResultFile("C:\\WATCHER_TEST\\DL_TEST\\result.txt");
    }

    @RabbitListener(queues = "DL_QUEUE_IN")
    public void receiveDlInMessage(final String message) {
        log.info("Receive DL_QUEUE_OUT");
        log.info(message.toString());
        fileWriter.writeResultFile("C:\\WATCHER_TEST\\DL_TEST\\result.txt");
    }

    @RabbitListener(queues = "DL_QUEUE_OUT")
    public void receiveDlOutMessage(final String message) {
        log.info("Receive DL_QUEUE_OUT");
        log.info(message.toString());
        fileWriter.writeResultFile("C:\\WATCHER_TEST\\ADC_TEST\\result.txt");
    }

    @RabbitListener(queues = "ADC_QUEUE_OUT")
    public void receiveAdcMessage(final String message) {
        log.info("Receive ADC_QUEUE_OUT");
        log.info(message.toString());
        fileWriter.writeResultFile("C:\\WATCHER_TEST\\REVIEW_TEST\\result.txt");

    }

    @RabbitListener(queues = "REVIEW_CLIENT_QUEUE")
    public void receiveReviewMessage(final String message) {
        log.info("Receive REVIEW_CLIENT_QUEUE");
        log.info(message.toString());
        log.info("=====FINISH=====");
    }
}
