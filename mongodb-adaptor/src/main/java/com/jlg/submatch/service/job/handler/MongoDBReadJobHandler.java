package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.repository.JobRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoDBReadJobHandler extends AbstractMongoDBJobHandler implements ReadJobHandler {

    private final JobRepository jobRepository;

    public MongoDBReadJobHandler(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Optional<Job> findById(String id) {
        var objectId = new ObjectId(id);
        var entity = jobRepository.findByIdAndDeletedAtIsNull(objectId);
        return entity.map(this::toDomainEntity);
    }
}
