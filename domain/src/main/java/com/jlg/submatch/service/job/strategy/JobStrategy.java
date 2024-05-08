package com.jlg.submatch.service.job.strategy;

import com.jlg.submatch.service.job.handler.CreateJobHandler;
import com.jlg.submatch.service.job.handler.DeleteJobHandler;
import com.jlg.submatch.service.job.handler.ReadJobHandler;
import com.jlg.submatch.service.job.handler.UpdateJobHandler;
import com.jlg.submatch.service.job.model.Job;

import java.util.Optional;

public interface JobStrategy {
    Optional<CreateJobHandler> createJobHandler(Job job);

    Optional<ReadJobHandler> readJobHandler();

    Optional<UpdateJobHandler> updateJobHandler();

    Optional<DeleteJobHandler> deleteJobHandler();
}
