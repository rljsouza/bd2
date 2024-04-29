package com.backendapiproject.searchandservice.core.domain;

import java.util.List;

public class Review {
    private Long id;
    private Customer customer;
    private String reviewDescription;
    private List<String> images;

    public Review() {
    }

    public Review(List<String> images, String reviewDescription, Customer customer, Long id) {
        this.images = images;
        this.reviewDescription = reviewDescription;
        this.customer = customer;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImage(List<String> images) {
        this.images = images;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
