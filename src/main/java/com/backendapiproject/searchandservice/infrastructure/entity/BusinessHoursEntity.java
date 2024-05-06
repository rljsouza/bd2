package com.backendapiproject.searchandservice.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_business_hours")
@Entity
public class BusinessHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opening_time")
    private LocalDateTime openingTime;

    @Column(name = "closing_time")
    private LocalDateTime closingTime;

    @ManyToMany
    @JoinTable(
            name = "business_hours_days",
            joinColumns = @JoinColumn(name = "business_hours_id"),
            inverseJoinColumns = @JoinColumn(name = "day_id")
    )
    private List<DayEntity> days;

    @ElementCollection
    @Column(name = "except_date")
    private List<LocalDate> exceptDates;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
}