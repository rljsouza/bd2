package com.backendapiproject.searchandservice.infrastructure.entity;

import com.backendapiproject.searchandservice.infrastructure.entity.enums.ServiceStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_service")
@Entity
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "duration")
    private Integer duration;

    @ManyToMany
    @JoinTable(
            name = "service_service_type",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "service_type_id")
    )
    private List<ServiceTypeEntity> serviceTypes;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ServiceStatus status;

    @ElementCollection
    @Column(name = "image_url")
    private List<String> images;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<BusinessHoursEntity> businessHours;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;

}

