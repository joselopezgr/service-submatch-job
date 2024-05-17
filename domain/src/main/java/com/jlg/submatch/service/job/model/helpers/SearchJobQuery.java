package com.jlg.submatch.service.job.model.helpers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchJobQuery {
    private SearchParameters parameters;
    private Integer page;
    private Integer maxResults;
    private String orderBy;
    private String sortOrder;
}
