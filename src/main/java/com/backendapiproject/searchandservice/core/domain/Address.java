package com.backendapiproject.searchandservice.core.domain;

public class Address {

    private String street;
    private String complement;
    private Integer number;
    private String neighborhood;
    private String zipCode;
    private City city;

    public Address() {
    }

    public Address(String street, String complement, Integer number, String neighborhood, String zipCode, City city) {
        this.street = street;
        this.complement = complement;
        this.number = number;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
