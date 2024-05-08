package com.jlg.submatch.service.user.customRepository;

import com.jlg.submatch.service.user.model.JobEntity;
import org.bson.types.ObjectId;

public interface CustomJobRepository {

    JobEntity softDelete(ObjectId id);
}
