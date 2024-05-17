package com.jlg.submatch.service.job.strategy;

import com.jlg.submatch.service.job.handler.*;
import com.jlg.submatch.service.job.model.Job;

import java.util.Optional;

public interface JobStrategy {
    Optional<CreateJobHandler> createJobHandler(Job job);

    Optional<ReadJobHandler> readJobHandler();

    Optional<UpdateJobHandler> updateJobHandler();

    Optional<DeleteJobHandler> deleteJobHandler();

    Optional<SearchJobHandler> searchJobHandler();
}
