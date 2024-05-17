package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.model.helpers.SearchJobQuery;

import java.util.List;
import java.util.Optional;

public interface SearchJobHandler {
    List<Job> search(SearchJobQuery query);
}
