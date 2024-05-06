package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.core.domain.Appointment;
import com.backendapiproject.searchandservice.core.domain.BusinessHours;
import com.backendapiproject.searchandservice.core.domain.Day;
import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.core.domain.ServiceAvailability;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.AppointmentUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListServiceAvailableUseCase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListServiceAvailableUseCaseImpl implements ListServiceAvailableUseCase {

    private final GetProfessionalByIdUseCase getProfessionalByIdUseCase;
    private final AppointmentUseCase appointmentUseCase;

    public ListServiceAvailableUseCaseImpl(GetProfessionalByIdUseCase getProfessionalByIdUseCase, AppointmentUseCase appointmentUseCase) {
        this.getProfessionalByIdUseCase = getProfessionalByIdUseCase;
        this.appointmentUseCase = appointmentUseCase;
    }

    @Override
    public List<ServiceAvailability> execute(Long professionalId, Long serviceId) {
        var professional = getProfessionalByIdUseCase.execute(professionalId);
        Service service = professional.getServices()
                .stream()
                .filter(ser -> ser.getId().equals(serviceId))
                .findFirst().orElseThrow(() -> {throw new NotFoundException("Serviço não encontrado");});


        return generateServiceAvailability(service, service.getBusinessHours(), professionalId);
    }

    public List<ServiceAvailability> generateServiceAvailability(Service service, List<BusinessHours> businessHoursList, Long professionalId) {
        List<ServiceAvailability> availabilities = new ArrayList<>();
        businessHoursList.forEach(businessHours -> {
            for (Day day : businessHours.getDays()) {
                if (businessHours.getExceptDates() != null && businessHours.getExceptDates().contains(LocalDate.now())) {
                    continue;
                }

                LocalTime openingTime = businessHours.getOpeningTime();
                LocalTime closingTime = businessHours.getClosingTime();
                while (openingTime.plusMinutes(service.getDuration()).isBefore(closingTime)) {
                    LocalTime endTime = openingTime.plusMinutes(service.getDuration());
                    if (endTime.isAfter(closingTime)) {
                        break;
                    }

                    if (!isAppointmentScheduled(professionalId, service.getId(), day, openingTime, endTime)) {
                        ServiceAvailability availability = new ServiceAvailability();
                        availability.setServiceId(service.getId());
                        availability.setProfessionalId(professionalId);
                        availability.setDayOfWeek(day.getName());
                        availability.setStartTime(openingTime);
                        availability.setEndTime(endTime);
                        availability.setValue(service.getValue());
                        availability.setExceptDates(businessHours.getExceptDates());
                        availabilities.add(availability);
                    }

                    openingTime = endTime;
                }
            }
        });
        return availabilities;
    }

    private boolean isAppointmentScheduled(Long professionalId, Long serviceId, Day day, LocalTime startTime, LocalTime endTime) {
        List<Appointment> appointments = appointmentUseCase.listServiceAppointmentsUByServiceId(professionalId, serviceId);
        for (Appointment appointment : appointments) {
            if (appointment.getDate().getDayOfWeek().name().equals(day.getName().name())
                    && Objects.nonNull(appointment.getTime()) &&
                    ( appointment.getTime().isAfter(startTime) &&
                    appointment.getTime().isBefore(endTime) ||  appointment.getTime().equals(startTime)) ) {
                return true;
            }
        }
        return false;
    }
}
