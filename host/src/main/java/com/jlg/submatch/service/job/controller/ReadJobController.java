package com.jlg.submatch.service.job.controller;

import com.jlg.submatch.service.job.dto.JobResponseDTO;
import com.jlg.submatch.service.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/jobs")
public class ReadJobController extends AbstractJobController {

    final JobService jobService;

    public ReadJobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(path = "/findBy/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public JobResponseDTO findById(@PathVariable String id) {
        var result = jobService.findById(id);
        return Optional.ofNullable(result)
                .map(this::convertToResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<JobResponseDTO> findAll() {
        var result = jobService.findAll();
        return Optional.ofNullable(result)
                .map(this::convertToResponseDTOList)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }
}