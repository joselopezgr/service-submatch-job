package com.jlg.submatch.service.job.handler;

import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.model.JobEntity;

import java.util.List;

abstract class AbstractMongoDBJobHandler {

    JobEntity toDBEntity(Job job){
        return new JobEntity(
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getSalary(),
                job.getOrganisationId(),
                job.getStatus(),
                job.getContactEmail()
        );
    }

    Job toDomainEntity(JobEntity jobEntity){
        return Job.builder()
                .id(jobEntity.getId())
                .title(jobEntity.getTitle())
                .description(jobEntity.getDescription())
                .location(jobEntity.getLocation())
                .salary(jobEntity.getSalary())
                .organisationId(jobEntity.getOrganisationId())
                .status(jobEntity.getStatus())
                .contactEmail(jobEntity.getContactEmail())
                .build();
    }

    List<Job> toDomainEntityList(List<JobEntity> jobEntities){
        return jobEntities.stream()
                .map(this::toDomainEntity)
                .toList();
    }
}
