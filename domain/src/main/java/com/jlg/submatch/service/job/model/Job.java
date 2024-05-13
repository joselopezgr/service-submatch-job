package com.jlg.submatch.service.job.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Job {
    @Builder.Default
    private String id = null;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String location;

    @NonNull
    private String salary;

    @NonNull
    private String company;

    @NonNull
    private String status;

    @NonNull
    private String postedBy;

    @NonNull
    private String contactEmail;

}

