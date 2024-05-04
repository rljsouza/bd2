package com.backendapiproject.searchandservice.infrastructure.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_professional")
@Entity
public class ProfessionalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "establishment_name")
    private String establishmentName;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "cnpj")
    private String CNPJ;

    @Column(name = "cpf")
    private String CPF;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "professional_service",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<ServiceEntity> services = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_data_id")
    private AccessDataEntity accessData;
}
