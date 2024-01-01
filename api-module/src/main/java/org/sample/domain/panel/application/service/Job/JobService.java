package org.sample.domain.panel.application.service.Job;

import lombok.RequiredArgsConstructor;
import org.sample.common.enums.JobType;
import org.sample.domain.panel.application.port.in.JobUseCase;
import org.sample.job.Job;
import org.sample.job.JobFactory;

import java.util.Queue;

@RequiredArgsConstructor
public class JobService implements JobUseCase {

    public final JobFactory jobFactory;

    @Override
    public void assignNextJob(Queue<String> jobs) {
        if (jobs.isEmpty()) {
            return;
        }
        String jobName = jobs.poll();
        Job job = jobFactory.createJob(JobType.getJobType(jobName));
        job.execute();
        assignNextJob(jobs);
    }


}
