package com.jlg.submatch.service.job.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection = "jobs")
public class JobEntity {
    @Id
    private String id;

    private final String title;

    private final String description;

    private final String location;

    private final String salary;

    private final String company;

    private final String status;

    private final String postedBy;

    private final String contactEmail;

    private LocalDateTime deletedAt;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;

}
