package com.jlg.submatch.service.job.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String salary;

    @NotNull()
    private String company;

    @NotNull()
    private String status;

    @NotNull()
    private String postedBy;
}
