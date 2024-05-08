package com.jlg.submatch.service.user.strategy;

import com.jlg.submatch.service.job.handler.CreateJobHandler;
import com.jlg.submatch.service.job.handler.DeleteJobHandler;
import com.jlg.submatch.service.job.handler.ReadJobHandler;
import com.jlg.submatch.service.job.handler.UpdateJobHandler;
import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.strategy.JobStrategy;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@EnableMongoAuditing
public class MongoDBJobStrategy implements JobStrategy {

    private final CreateJobHandler createJobHandler;
    private final ReadJobHandler readJobHandler;
    private final UpdateJobHandler updateJobHandler;
    private final DeleteJobHandler deleteJobHandler;

    public MongoDBJobStrategy(CreateJobHandler createJobHandler, ReadJobHandler readJobHandler, UpdateJobHandler updateJobHandler, DeleteJobHandler deleteJobHandler) {
        this.createJobHandler = createJobHandler;
        this.readJobHandler = readJobHandler;
        this.updateJobHandler = updateJobHandler;
        this.deleteJobHandler = deleteJobHandler;
    }

    @Override
    public Optional<CreateJobHandler> createJobHandler(Job job) {
        return Optional.of(createJobHandler);
    }

    @Override
    public Optional<ReadJobHandler> readJobHandler() {
        return Optional.of(readJobHandler);
    }

    @Override
    public Optional<UpdateJobHandler> updateJobHandler() {
        return Optional.of(updateJobHandler);
    }

    @Override
    public Optional<DeleteJobHandler> deleteJobHandler() { return Optional.of(deleteJobHandler); }

}
