package com.jlg.submatch.service.job.controller;

import com.jlg.submatch.service.job.dto.JobResponseDTO;
import com.jlg.submatch.service.job.dto.SearchJobRequestDTO;
import com.jlg.submatch.service.job.dto.SearchJobResponseDTO;
import com.jlg.submatch.service.job.model.helpers.SearchJobQuery;
import com.jlg.submatch.service.job.model.helpers.SearchParameters;
import com.jlg.submatch.service.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/jobs/search")
public class SearchJobController extends AbstractJobController {
    final JobService jobService;

    public SearchJobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SearchJobResponseDTO search(@RequestBody SearchJobRequestDTO searchJobRequestDTO) {
        String title = searchJobRequestDTO.getSearchQuery().getParameters().getJobTitle();
        String location = searchJobRequestDTO.getSearchQuery().getParameters().getLocation();
        String salary = searchJobRequestDTO.getSearchQuery().getParameters().getSalary();
        String experience = searchJobRequestDTO.getSearchQuery().getParameters().getExperience();

        SearchParameters searchParameters = SearchParameters.builder()
                .jobTitle(Objects.nonNull(title) ? title : null)
                .location(Objects.nonNull(location) ? location : null)
                .salary(Objects.nonNull(salary) ? salary : null)
                .experience(Objects.nonNull(experience) ? experience : null)
                .build();

        SearchJobQuery searchQuery = SearchJobQuery.builder()
                .parameters(searchParameters)
                .build();

        List<JobResponseDTO> result = jobService
                .search(searchQuery)
                .stream()
                .map(this::convertToResponseDTO)
                .toList();

        return SearchJobResponseDTO.builder()
                .searchResults(result)
                .page(searchJobRequestDTO.getSearchQuery().getPage())
                .build();
    }
}
