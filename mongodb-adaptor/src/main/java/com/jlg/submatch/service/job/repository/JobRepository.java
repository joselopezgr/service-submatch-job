package com.jlg.submatch.service.job.repository;

import com.jlg.submatch.service.job.customRepository.CustomJobRepository;
import com.jlg.submatch.service.job.model.JobEntity;
import com.jlg.submatch.service.job.model.helpers.SearchJobQuery;
import org.bson.types.ObjectId;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends ListCrudRepository<JobEntity, ObjectId>, CustomJobRepository {
    Optional<JobEntity> findByIdAndDeletedAtIsNull(ObjectId id);
}
