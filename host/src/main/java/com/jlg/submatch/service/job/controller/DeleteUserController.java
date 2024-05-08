package com.jlg.submatch.service.job.controller;

import com.jlg.submatch.service.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job/{id}")
public class DeleteUserController {
    private final JobService jobService;

    public DeleteUserController(JobService jobService) {
        this.jobService = jobService;
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        jobService.delete(id);
    }
}
