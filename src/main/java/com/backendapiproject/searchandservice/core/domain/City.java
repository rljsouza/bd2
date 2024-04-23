package com.backendapiproject.searchandservice.core.domain;

public class City {

    private Long id;
    private String name;
    private String abbreviation;
    private State state;
    private String areaCode;

    public City() {
    }

    public City(Long id, String name, String abbreviation, State state, String areaCode) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.state = state;
        this.areaCode = areaCode;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
