package com.jlg.submatch.service.user.repository;

import com.jlg.submatch.service.user.customRepository.CustomJobRepository;
import com.jlg.submatch.service.user.model.JobEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends ListCrudRepository<JobEntity, ObjectId>, CustomJobRepository {
    Optional<JobEntity> findByIdAndDeletedAtIsNull(ObjectId id);
}
