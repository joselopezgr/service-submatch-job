package com.jlg.submatch.service.job.customRepository;

import com.jlg.submatch.service.job.model.JobEntity;
import org.bson.types.ObjectId;

public interface CustomJobRepository {

    JobEntity softDelete(ObjectId id);
}
