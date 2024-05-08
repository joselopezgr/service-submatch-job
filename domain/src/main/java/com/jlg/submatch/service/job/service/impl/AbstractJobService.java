package com.jlg.submatch.service.job.service.impl;

import com.jlg.submatch.service.job.exception.JobException;
import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.service.JobService;
import com.jlg.submatch.service.job.strategy.JobStrategy;

import java.util.List;
import java.util.Optional;

public abstract class AbstractJobService implements JobService {

    private final List<JobStrategy> strategies;

    protected AbstractJobService(List<JobStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public Job create(Job job) {
        var handler = strategies.stream()
                .map(strategy -> strategy.createJobHandler(job))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new JobException("Handler not found"));
        return handler.create(job);
    }

    @Override
    public Job findById(String id) {
        var handler = strategies.stream()
                .map(JobStrategy::readJobHandler)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new JobException("Handler not found"));
        return handler.findById(id).orElseThrow(() -> new JobException("Job not found"));
    }

    @Override
    public Job update(Job job) {
        var handler = strategies.stream()
                .map(JobStrategy::updateJobHandler)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new JobException("Handler not found"));
        return handler.update(job).orElseThrow(() -> new JobException("Job not found"));
    }

    @Override
    public Job delete(String id) {
        var handler = strategies.stream()
                .map(JobStrategy::deleteJobHandler)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new JobException("Handler not found"));
        return handler.delete(id).orElseThrow(() -> new JobException("Job not found"));
    }
}
