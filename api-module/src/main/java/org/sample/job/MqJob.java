package org.sample.job;

import org.springframework.stereotype.Component;

@Component
public class MqJob implements Job {
    @Override
    public void execute() {
        System.out.println("Mq Job Excute");
    }
}
