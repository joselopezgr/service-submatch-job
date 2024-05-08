package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.model.Job;

import java.util.Optional;

public interface DeleteJobHandler {
    Optional<Job> delete(String id);
}
