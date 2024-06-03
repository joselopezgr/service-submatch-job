package com.jlg.submatch.service.job.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class Job {
    @Builder.Default()
    private UUID id = null;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String location;

    @NonNull
    private String salary;

    @NonNull
    private String organisationName;

    @NonNull
    private UUID organisationId;

    @NonNull
    private String startDate;

    @NonNull
    private String endDate;

    @NonNull
    private JobStatus status;

    private String acceptedApplicantId;

    @NonNull
    private String contactEmail;

    private List<String> applicantsIds;

    private Boolean isDeleted;
}

