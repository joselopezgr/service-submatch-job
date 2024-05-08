package com.jlg.submatch.service.job.controller;

import com.jlg.submatch.service.job.dto.JobResponseDTO;
import com.jlg.submatch.service.job.dto.JobRequestDTO;
import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs/create")
//@Validated
public class CreateJobController extends AbstractJobController {

    final JobService jobService;

    public CreateJobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public JobResponseDTO create(@RequestBody @Valid JobRequestDTO requestBody) {
        Job job = this.convertToDomainEntity(requestBody);
        System.out.println("Job: " + job);
        var service = jobService.create(job);
        System.out.println("Service: " + service);

        return this.convertToResponseDTO(service);
    }
}
