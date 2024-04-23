package com.backendapiproject.searchandservice.core.domain;

public class Professional {

    private Long id;
    private String establishmentName;
    private String name;
    private Address address;
    private String CNPJ;
    private String CPF;
    private String phone;
    private String email;

    public Professional() {
    }

    public Professional(Long id, String establishmentName, String name, Address address, String CNPJ, String CPF, String phone, String email) {
        this.id = id;
        this.establishmentName = establishmentName;
        this.name = name;
        this.address = address;
        this.CNPJ = CNPJ;
        this.CPF = CPF;
        this.phone = phone;
        this.email = email;
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
}
