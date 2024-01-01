package org.sample.config.simple;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class HelloBatchJobConfiguration {

    private static final String JOB_NAME = "helloJob";
    private static final String STEP_1_NAME = "helloStep";
    private static final String MESSAGE = "Hello, Spring Batch!!!";


    @Bean
    public JdbcTransactionManager batchTransactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }

    @Bean
    public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
        return new JobBuilder(JOB_NAME, jobRepository)
                .start(step(jobRepository, transactionManager))
                .next(step(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder(STEP_1_NAME, jobRepository)
                .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
                    System.out.println(MESSAGE);
                    return RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }


}
