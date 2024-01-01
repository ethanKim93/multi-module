package org.sample.job;

import org.sample.common.enums.JobType;
import org.sample.common.exeption.CustomApiException;

public interface JobFactory {
    Job createJob(JobType jobType);
}