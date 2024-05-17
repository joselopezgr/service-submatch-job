package com.jlg.submatch.service.job.customRepository;

import com.jlg.submatch.service.job.model.JobEntity;
import com.jlg.submatch.service.job.model.helpers.SearchJobQuery;
import org.bson.types.ObjectId;

import java.util.List;

public interface CustomJobRepository {

    JobEntity softDelete(ObjectId id);

    List<JobEntity> customSearch(SearchJobQuery searchQuery);

}
