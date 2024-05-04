package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.BusinessHours;

import java.util.List;

public interface BusinessHoursUseCase {
    List<BusinessHours> create(List<BusinessHours> businessHours);
    void deleteById(Long id);
    BusinessHours getBusinessHoursById(Long id);
    List<BusinessHours> listBusinessHours();
}
