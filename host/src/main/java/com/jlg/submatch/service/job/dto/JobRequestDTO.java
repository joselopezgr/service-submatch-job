package com.jlg.submatch.service.job.dto;

import com.jlg.submatch.service.job.model.JobStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class JobRequestDTO {

    @NotNull()
    private String title;

    @NotNull()
    private String description;

    @NotNull()
    private String location;

    @NotNull()
    private Integer salary;

    @NotNull()
    private UUID organisationId;

    @NotNull()
    private JobStatus status;

    @NotNull()
    private String postedBy;

    @NotNull()
    private String contactEmail;
}
