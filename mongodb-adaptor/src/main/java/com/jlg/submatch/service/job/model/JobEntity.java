package com.jlg.submatch.service.job.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Document(collection = "jobs")
public class JobEntity {
    @Id
    private UUID id;

    private final String title;

    private final String description;

    private final String location;

    private final Integer salary;

    private final UUID organisationId;

    private final JobStatus status;

    private final String contactEmail;

    private LocalDateTime deletedAt;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;

}
