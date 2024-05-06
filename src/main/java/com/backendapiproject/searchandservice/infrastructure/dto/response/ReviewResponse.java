package com.backendapiproject.searchandservice.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReviewResponse {

    private Long id;
    private CustomerResponse customerResponse;
    private String reviewDescription;
    private List<String> images;


}
