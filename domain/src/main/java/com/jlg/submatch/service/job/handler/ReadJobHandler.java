package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.model.Job;

import java.util.List;
import java.util.Optional;

public interface ReadJobHandler {
    Optional<Job> findById(String id);

    Optional<List<Job>> findAll();
}

