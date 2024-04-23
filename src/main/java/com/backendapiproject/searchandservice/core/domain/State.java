package com.backendapiproject.searchandservice.core.domain;

public class State {

    private Long id;
    private String name;
    private String abbreviation;
    private Country country;

    public  State(){}

    public State(Long id, String name, String abbreviation, Country country) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.country = country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
