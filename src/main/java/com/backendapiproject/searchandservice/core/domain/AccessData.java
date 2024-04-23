package com.backendapiproject.searchandservice.core.domain;

public class AccessData {

    private Long id;
    private Professional professional;
    private Customer customer;
    private String password;

    public AccessData() {
    }

    public AccessData(Long id, Professional professional, Customer customer, String password) {
        this.id = id;
        this.professional = professional;
        this.customer = customer;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
