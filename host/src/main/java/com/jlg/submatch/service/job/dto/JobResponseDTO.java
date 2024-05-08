package com.jlg.submatch.service.job.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobResponseDTO {
    @NotNull()
    private String id;

    @NotNull()
    private String title;

    @NotNull()
    private String description;

    @NotNull()
    private String location;

    @NotNull()
    private String salary;

    @NotNull()
    private String company;
}
