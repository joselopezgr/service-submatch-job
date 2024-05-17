package com.jlg.submatch.service.job.service;

import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.model.helpers.SearchJobQuery;

import java.util.List;

public interface JobService {
    Job create(Job job);
    Job findById(String id);
    List<Job> findAll();
    Job update(Job job);
    Job delete(String id);
    List<Job> search(SearchJobQuery query);
}
