package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.model.JobEntity;
import com.jlg.submatch.service.job.repository.JobRepository;
import com.jlg.submatch.service.job.exception.MongoDBExceptionHandler;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoDBDeleteJobHandler extends AbstractMongoDBJobHandler implements DeleteJobHandler{

    private final JobRepository jobRepository;

    public MongoDBDeleteJobHandler(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    @MongoDBExceptionHandler(message = "Error deleting user")
    public Optional<Job> delete(String id) {
        var objectId = new ObjectId(id);
        Optional<JobEntity> dbEntity = jobRepository.findByIdAndDeletedAtIsNull(objectId);

        if(dbEntity.isEmpty()) {
            return Optional.empty();
        }

        JobEntity result = jobRepository.softDelete(objectId);

        return Optional.of(this.toDomainEntity(result));
    }
}
