package com.jlg.submatch.service.job.dto;

import com.jlg.submatch.service.job.model.helpers.SearchJobQuery;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchJobRequestDTO {
    @NotNull(message = "searchQuery cannot be null")
    private SearchJobQuery searchQuery;
}
