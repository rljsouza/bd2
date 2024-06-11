package com.backendapiproject.searchandservice.infrastructure.controller;


import com.backendapiproject.searchandservice.infrastructure.dto.AppointmentReportDTO;
import com.backendapiproject.searchandservice.infrastructure.dto.ProfessionalReviewDTO;
import com.backendapiproject.searchandservice.infrastructure.dto.ServiceCall;
import com.backendapiproject.searchandservice.infrastructure.repository.ProfessionalReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/report")
@RequiredArgsConstructor
public class ReviewsController {


    private final ProfessionalReviewRepository reviewRepository;

    @GetMapping("/reviews/professionals")
    public ResponseEntity<List<ProfessionalReviewDTO>> getAllProfessionalsReviews() {
        return new ResponseEntity<>(reviewRepository.getAllProfessionalReviews(), HttpStatus.OK);
    }

    @GetMapping("/appointment/professionals")
    public ResponseEntity<List<AppointmentReportDTO>> getAppointmentReportByProfessional() {
        return new ResponseEntity<>(reviewRepository.getAppointmentReportByProfessional(), HttpStatus.OK);
    }


    @PostMapping("/generate-and-store-monthly-report")
    public ResponseEntity<String> generateAndStoreMonthlyReport() {
        reviewRepository.generateAndStoreMonthlyReport();
        return ResponseEntity.ok("Monthly report generated and stored successfully.");
    }

    @PostMapping("/generate-and-export-monthly-report")
    public ResponseEntity<String> generateAndExportMonthlyReport() {
        reviewRepository.generateAndExportMonthlyReport();
        return ResponseEntity.ok("Monthly report generated and exported successfully.");
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/update-service-status")
    public ResponseEntity<String> updateServiceStatus(@RequestBody ServiceCall serviceCall) {
        reviewRepository.updateServiceStatus(serviceCall);
        return ResponseEntity.ok("Service status updated successfully.");
    }

    @PostMapping("/generate-admin-report")
    public ResponseEntity<String> generateAdminReport() {
        reviewRepository.generateAdminReport();
        return ResponseEntity.ok("Admin report generated successfully.");
    }


}
