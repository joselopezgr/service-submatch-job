package com.jlg.submatch.service.job.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class JobResponseDTO {
    @NotNull()
    private UUID id;

    @NotNull()
    private String title;

    @NotNull()
    private String description;

    @NotNull()
    private String location;

    @NotNull()
    private String salary;

    @NotNull()
    private UUID organisationId;

    @NotNull()
    private String contactEmail;
}
