package com.backendapiproject.searchandservice.core.domain;

public class Country {

    private Long id;
    private String name;
    private String abbreviation;
    private String countryCode;


    public Country() {
    }

    public Country(Long id, String name, String abbreviation, String countryCode) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.countryCode = countryCode;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
