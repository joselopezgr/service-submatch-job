package com.jlg.submatch.service.job.controller;

import com.jlg.submatch.service.job.dto.JobRequestDTO;
import com.jlg.submatch.service.job.dto.JobResponseDTO;
import com.jlg.submatch.service.job.model.Job;

import java.util.List;

abstract class AbstractJobController {

    Job convertToDomainEntity(JobRequestDTO jobRequestDTO) {
        return Job.builder()
                .title(jobRequestDTO.getTitle())
                .description(jobRequestDTO.getDescription())
                .location(jobRequestDTO.getLocation())
                .salary(jobRequestDTO.getSalary())
                .company(jobRequestDTO.getCompany())
                .status(jobRequestDTO.getStatus())
                .postedBy(jobRequestDTO.getPostedBy())
                .build();
    }

    JobResponseDTO convertToResponseDTO(Job job) {
        return JobResponseDTO
                .builder()
                .id(job.getId())
                .title(job.getTitle())
                .description(job.getDescription())
                .location(job.getLocation())
                .salary(job.getSalary())
                .company(job.getCompany())
                .build();
    }

    List<JobResponseDTO> convertToResponseDTOList(List<Job> jobs) {
        return jobs.stream()
                .map(this::convertToResponseDTO)
                .toList();
    }
}