package com.backendapiproject.searchandservice.infrastructure.repository;

import com.backendapiproject.searchandservice.infrastructure.dto.AppointmentReportDTO;
import com.backendapiproject.searchandservice.infrastructure.dto.AvailabilityDTO;
import com.backendapiproject.searchandservice.infrastructure.dto.ProfessionalReviewDTO;
import com.backendapiproject.searchandservice.infrastructure.dto.ServiceCall;
import com.backendapiproject.searchandservice.infrastructure.dto.enums.DayOfWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProfessionalReviewRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<ProfessionalReviewDTO> getAllProfessionalReviews() {
        String sql = "SELECT * FROM all_professionals_reviews_view";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            ProfessionalReviewDTO dto = new ProfessionalReviewDTO();
            dto.setReviewId(resultSet.getLong("review_id"));
            dto.setReviewDescription(resultSet.getString("review_description"));
            dto.setCustomerId(resultSet.getLong("customer_id"));
            dto.setServiceId(resultSet.getLong("service_id"));
            dto.setProfessionalId(resultSet.getLong("professional_id"));
            dto.setProfessionalName(resultSet.getString("professional_name"));
            dto.setServiceDescription(resultSet.getString("service_description"));
            dto.setServiceTypeName(resultSet.getString("service_type_name"));
            return dto;
        });
    }

    public List<AppointmentReportDTO> getAppointmentReportByProfessional() {
        String sql = "SELECT * FROM appointment_report_by_professional_view";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AppointmentReportDTO appointment = new AppointmentReportDTO();
            appointment.setAppointmentId(rs.getLong("appointment_id"));
            appointment.setCustomerId(rs.getLong("customer_id"));
            appointment.setCustomerName(rs.getString("customer_name"));
            appointment.setServiceDescription(rs.getString("service_description"));
            appointment.setAppointmentDate(rs.getDate("appointment_date").toLocalDate());
            appointment.setAppointmentTime(rs.getTime("appointment_time").toLocalTime());
            appointment.setProfessionalId(rs.getLong("professional_id"));
            appointment.setProfessionalName(rs.getString("professional_name"));
            return appointment;
        });
    }
    public List<AvailabilityDTO> checkAvailability(Integer professionalId, Integer serviceId, Date appointmentDate) {
        String sql = "SELECT * FROM checkavailability(?, ?, ?::DATE);";
        return jdbcTemplate.query(sql, new Object[]{professionalId, serviceId, appointmentDate}, (rs, rowNum) -> {
            AvailabilityDTO availability = new AvailabilityDTO();
            availability.setProfessionalId(rs.getLong("professional_id"));
            availability.setProfessionalName(rs.getString("professional_name"));
            availability.setServiceId(rs.getLong("service_id"));
            availability.setServiceDescription(rs.getString("service_description"));
            availability.setTotalScheduledDuration(rs.getInt("total_scheduled_duration"));
            availability.setNewServiceDuration(rs.getInt("new_service_duration"));
            availability.setTotalWorkingMinutes(rs.getInt("total_working_minutes"));
            availability.setAvailability(rs.getBoolean("availability"));
            return availability;
        });
    }


    public int calculateServiceDuration(Integer serviceId, Integer professionalId) {
        String sql = "SELECT calculateserviceduration(?, ?)";
        return jdbcTemplate.queryForObject(sql, Integer.class, serviceId, professionalId);
    }

    public List<AvailabilityDTO> getAvailableProfessionals(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        String sql = "SELECT * FROM getavailableprofessionals(?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{dayOfWeek.name(), Time.valueOf(startTime), Time.valueOf(endTime)}, (rs, rowNum) -> {
            AvailabilityDTO availability = new AvailabilityDTO();
            availability.setProfessionalId(rs.getLong("professional_id"));
            availability.setProfessionalName(rs.getString("professional_name"));
            availability.setServiceTypeName(rs.getString("service_type_name"));
            availability.setAvailability(rs.getBoolean("availability"));
            return availability;
        });
    }


    public void generateAdminReport() {
        jdbcTemplate.execute("CALL generate_admin_report()");
    }
    public void generateAndStoreMonthlyReport() {
        jdbcTemplate.execute("CALL generate_and_store_monthly_report()");
    }

    public void updateServiceStatus(ServiceCall request) {
        jdbcTemplate.update("CALL update_service_status(?, ?);", request.getServiceId(), request.getStatus().name());
    }

    public void generateAndExportMonthlyReport() {
        jdbcTemplate.execute("CALL generate_and_export_monthly_report()");
    }

    public void deleteCustomerById(Integer professionalId) {
        String sql = "DELETE FROM tb_professional WHERE id = ?";
        jdbcTemplate.update(sql, professionalId);
    }

    public void updateServiceValue(Integer serviceId, double newValue) {
        String sql = "UPDATE public.tb_service SET value = ? WHERE id = ?";
        jdbcTemplate.update(sql, newValue, serviceId);
    }

}
