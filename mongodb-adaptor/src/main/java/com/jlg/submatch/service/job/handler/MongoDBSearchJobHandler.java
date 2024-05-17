package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.exception.MongoDBExceptionHandler;
import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.model.helpers.SearchJobQuery;
import com.jlg.submatch.service.job.repository.JobRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoDBSearchJobHandler extends AbstractMongoDBJobHandler implements SearchJobHandler {
    private final JobRepository repository;

    public MongoDBSearchJobHandler(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    @MongoDBExceptionHandler(message = "Job search failed")
    public List<Job> search(SearchJobQuery searchQuery) {
        return repository.customSearch(searchQuery).stream().map(this::toDomainEntity).toList();
    }
}
