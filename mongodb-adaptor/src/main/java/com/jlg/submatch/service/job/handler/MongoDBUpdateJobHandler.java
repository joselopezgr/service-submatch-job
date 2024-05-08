package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.exception.MongoDBExceptionHandler;
import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.model.JobEntity;
import com.jlg.submatch.service.job.repository.JobRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoDBUpdateJobHandler extends AbstractMongoDBJobHandler implements UpdateJobHandler {

    private final JobRepository jobRepository;

    public MongoDBUpdateJobHandler(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    @MongoDBExceptionHandler(message = "User update failed")
    public Optional<Job> update(Job updatedUser) {
        var objectId = new ObjectId(updatedUser.getId());
        Optional<JobEntity> dbEntity = this.jobRepository.findById(objectId);
        if(dbEntity.isEmpty()) {
            return Optional.empty();
        }

        JobEntity entityToSave = this.toDBEntity(updatedUser);
        entityToSave.setId(updatedUser.getId());
        jobRepository.save(entityToSave);
        return Optional.of(updatedUser);
    }
}
