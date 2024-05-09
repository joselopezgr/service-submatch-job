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
                job.getCompany(),
                job.getStatus(),
                job.getPostedBy()
        );
    }

    Job toDomainEntity(JobEntity jobEntity){
        return Job.builder()
                .id(jobEntity.getId())
                .title(jobEntity.getTitle())
                .description(jobEntity.getDescription())
                .location(jobEntity.getLocation())
                .salary(jobEntity.getSalary())
                .company(jobEntity.getCompany())
                .status(jobEntity.getStatus())
                .postedBy(jobEntity.getPostedBy())
                .build();
    }

    List<Job> toDomainEntityList(List<JobEntity> jobEntities){
        return jobEntities.stream()
                .map(this::toDomainEntity)
                .toList();
    }
}
