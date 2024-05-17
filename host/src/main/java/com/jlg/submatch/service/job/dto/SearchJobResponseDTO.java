package com.jlg.submatch.service.job.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SearchJobResponseDTO {
    private List<JobResponseDTO> searchResults;
    private Integer page;
}
