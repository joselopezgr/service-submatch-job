package com.jlg.submatch.service.job.service;

import com.jlg.submatch.service.job.model.Job;

public interface JobService {
    Job create(Job job);
    Job findById(String id);
    Job update(Job job);
    Job delete(String id);
}
