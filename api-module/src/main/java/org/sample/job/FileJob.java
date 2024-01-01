package org.sample.job;

import org.springframework.stereotype.Component;

@Component
public class FileJob implements Job {
    @Override
    public void execute() {
        System.out.println("File Job Excute");
    }
}
