package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.exception.MongoDBExceptionHandler;
import com.jlg.submatch.service.job.repository.JobRepository;
import org.springframework.stereotype.Component;

@Component
public class MongoDBCreateJobHandler extends AbstractMongoDBJobHandler implements CreateJobHandler {

    private final JobRepository jobRepository;

    public MongoDBCreateJobHandler(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    @MongoDBExceptionHandler(message = "Job creation failed")
    public Job create(Job job) {
        var entity = this.toDBEntity(job);

        var result = jobRepository.save(entity);
        job.setId(result.getId());

        return job;
    }
}
