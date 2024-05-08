package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.model.Job;

import java.util.Optional;

public interface UpdateJobHandler {
    Optional<Job> update(Job job);
}
