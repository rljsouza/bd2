package com.backendapiproject.searchandservice.core.domain;

public class Customer {

    private Long id;
    private String name;
    private String gender;
    private String nationality;
    private String CPF;
    private String RG;
    private Address address;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(Long id, String name, String gender, String nationality, String CPF, String RG, Address address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.CPF = CPF;
        this.RG = RG;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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