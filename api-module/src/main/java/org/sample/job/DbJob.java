package org.sample.job;

import org.springframework.stereotype.Component;

@Component
public class DbJob implements Job {
    @Override
    public void execute() {
        System.out.println("Db Job Excute");
    }
}
