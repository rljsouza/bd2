package com.backendapiproject.searchandservice.infrastructure.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_access_data")
@Entity
public class AccessDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "accessData")
    private Set<RoleEntity> roles;

    @OneToOne(mappedBy = "accessData")
    private CustomerEntity customer;

    @OneToOne(mappedBy = "accessData")
    private ProfessionalEntity professional;


}
