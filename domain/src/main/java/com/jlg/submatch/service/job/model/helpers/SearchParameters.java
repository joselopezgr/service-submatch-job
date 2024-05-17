package com.jlg.submatch.service.job.model.helpers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchParameters {
    private String jobTitle;
    private String organization;
    private String location;
    private String salary;
    private String experience;
}
