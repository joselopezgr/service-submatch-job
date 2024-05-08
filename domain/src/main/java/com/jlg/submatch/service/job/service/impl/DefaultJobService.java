package com.jlg.submatch.service.job.service.impl;

import com.jlg.submatch.service.job.strategy.JobStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class DefaultJobService extends AbstractJobService {
    public DefaultJobService(List<JobStrategy> strategies) {
    super(strategies);
    }
}