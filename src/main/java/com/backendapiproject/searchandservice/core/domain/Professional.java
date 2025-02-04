package com.backendapiproject.searchandservice.core.domain;


import java.util.ArrayList;
import java.util.List;

public class Professional {

    private Long id;
    private String establishmentName;
    private String name;
    private Address address;
    private String CNPJ;
    private String CPF;
    private String phone;
    private String email;
    private List<Service> services = new ArrayList<>();
    private AccessData accessData;

    public Professional() {
    }

    public Professional(Long id, String establishmentName, String name, Address address, String CNPJ, String CPF, String phone, String email, List<Service> services, AccessData accessData) {
        this.id = id;
        this.establishmentName = establishmentName;
        this.name = name;
        this.address = address;
        this.CNPJ = CNPJ;
        this.CPF = CPF;
        this.phone = phone;
        this.email = email;
        this.services = services;
        this.accessData = accessData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public AccessData getAccessData() {
        return accessData;
    }

    public void setAccessData(AccessData accessData) {
        this.accessData = accessData;
    }
}
