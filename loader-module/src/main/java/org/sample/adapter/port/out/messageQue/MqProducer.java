package org.sample.adapter.port.out.messageQue;

public interface MqProducer {
    public void sendMqMessage(String queueName, String message);
}
