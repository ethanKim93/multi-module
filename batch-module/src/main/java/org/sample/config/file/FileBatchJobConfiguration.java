package org.sample.config.file;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.math.BigDecimal;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FileBatchJobConfiguration {
    public static final int CHUNK_SIZE = 2;
    public static final int ADD_PRICE = 1000;

    private static final String JOB_NAME = "fileJob";
    private static final String STEP_NAME = "fileStep";

    private Resource inputFileResource = new FileSystemResource("batch-module/input/sample-product.csv");
    private WritableResource outputFileResource = new FileSystemResource("batch-module/output/output-product.csv");

    @Bean
    public Job fileJob(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
        return new JobBuilder(JOB_NAME, jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(fileStep(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step fileStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder(STEP_NAME, jobRepository)
                .<Product, Product>chunk(CHUNK_SIZE, transactionManager)
                .reader(fileItemReader())
                .processor(fileItemProcessor())
                .writer(fileItemWriter())
                .build();

    }

    @Bean
    public FlatFileItemReader fileItemReader() {
        // 아이템 리더 생성
        FlatFileItemReader<Product> productItemReader = new FlatFileItemReader<>();
        productItemReader.setResource(this.inputFileResource);

        // 파일의 라인을 어떻게 가져올 것인가? (기본은 콤마)
        DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(new DelimitedLineTokenizer());
        lineMapper.setFieldSetMapper(new ProductFieldSetMapper());

        productItemReader.setLineMapper(lineMapper);
        return productItemReader;
    }

    @Bean
    public ItemProcessor<Product, Product> fileItemProcessor() {
        // In: Product --> Out: Product
        return product -> {
            BigDecimal updatedPrice = product.getPrice().add(new BigDecimal(ADD_PRICE));
            log.info("[ItemProcessor] Updated product price - {}", updatedPrice);
            product.setPrice(updatedPrice);
            return product;
        };
    }

    @Bean
    public FlatFileItemWriter<Product> fileItemWriter() {
        FlatFileItemWriter flatFileItemWriter = new FlatFileItemWriter();
        flatFileItemWriter.setResource(outputFileResource);
        flatFileItemWriter.setAppendAllowed(true);

        DelimitedLineAggregator<Product> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setFieldExtractor(new BeanWrapperFieldExtractor<>() {
            {
                setNames(new String[]{"id", "name", "price"});
            }
        });
        flatFileItemWriter.setLineAggregator(lineAggregator);

        return flatFileItemWriter;
    }
}
