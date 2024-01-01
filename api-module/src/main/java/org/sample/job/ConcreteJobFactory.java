package org.sample.job;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sample.common.enums.JobType;
import org.sample.common.exeption.CustomApiException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ConcreteJobFactory implements JobFactory {

    private final FileJob fileJob;
    private final DbJob dbJob;
    private final MqJob mqJob;
    private final ImageJob imageJob;


    public Job createJob(JobType jobType) {
        switch (jobType) {
            case FILE:
                return fileJob;
            case DB:
                return dbJob;
            case MQ:
                return mqJob;
            case IMAGE:
                return imageJob;
            default:
                throw new IllegalArgumentException("Invalid job type: " + jobType);
        }
    }
}