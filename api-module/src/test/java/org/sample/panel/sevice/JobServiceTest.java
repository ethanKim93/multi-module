package org.sample.panel.sevice;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.sample.domain.panel.application.service.Job.JobService;
import org.sample.job.ConcreteJobFactory;
import org.sample.job.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Queue;


@SpringBootTest
public class JobServiceTest {

    @Autowired
    private JobFactory concreteJobFactory;

    @Test
    public void jobTest() {

        JobService jobService = new JobService(concreteJobFactory);
        Queue<String> jobs = new LinkedList<>();
        jobs.add("MQ");
        jobs.add("FILE");
        jobs.add("DB");
        jobs.add("FILE");
        jobs.add("IMAGE");

        jobService.assignNextJob(jobs);

    }
}
