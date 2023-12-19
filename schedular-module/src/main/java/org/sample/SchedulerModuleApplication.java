package org.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchedulerModuleApplication.class, args);
    }
}