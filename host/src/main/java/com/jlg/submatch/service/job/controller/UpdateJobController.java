package com.jlg.submatch.service.job.controller;

import com.jlg.submatch.service.job.dto.JobRequestDTO;
import com.jlg.submatch.service.job.dto.JobResponseDTO;
import com.jlg.submatch.service.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs/{id}")
public class UpdateJobController extends AbstractJobController {

    final JobService jobService;

    public UpdateJobController(JobService jobService) { this.jobService = jobService; }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public JobResponseDTO update(@RequestBody JobRequestDTO userRequest, @PathVariable("id") String id) {
        var user = this.convertToDomainEntity(userRequest);
        user.setId(id);

        var updatedUser = jobService.update(user);

        return this.convertToResponseDTO(updatedUser);
    }
}
