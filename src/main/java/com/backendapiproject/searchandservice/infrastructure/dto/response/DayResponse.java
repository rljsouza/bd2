package com.backendapiproject.searchandservice.infrastructure.dto.response;

import com.backendapiproject.searchandservice.infrastructure.dto.enums.DayOfWeek;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DayResponse {

    private Long id;
    private DayOfWeek name;


}
