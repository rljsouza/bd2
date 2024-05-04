package com.backendapiproject.searchandservice.infrastructure.dto.request;


import com.backendapiproject.searchandservice.infrastructure.dto.enums.DayOfWeek;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayRequest {

    @NotBlank
    private DayOfWeek name;
}
