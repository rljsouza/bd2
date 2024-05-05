package com.backendapiproject.searchandservice.core.domain;

public class Country {

    private Long id;
    private String name;
    private String namePt;
    private String abbreviation;
    private Integer countryCode;

    public Country() {
    }

    public Country(Long id, String name, String namePt, String abbreviation, Integer countryCode) {
        this.id = id;
        this.name = name;
        this.namePt = namePt;
        this.abbreviation = abbreviation;
        this.countryCode = countryCode;
    }

    public Long getId() {
        return id;
    }

    public String getNamePt() {
        return namePt;
    }

    public void setNamePt(String namePt) {
        this.namePt = namePt;
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

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }
}
