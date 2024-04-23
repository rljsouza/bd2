package com.backendapiproject.searchandservice.core.domain;

public class Review {
    private Long id;
    private Professional professional;
    private Customer customer;
    private String reviewDescription;
    private Review rating;
    private String image;

    public Review() {
    }

    public Review(String image, String reviewDescription, Customer customer, Review rating, Professional professional, Long id) {
        this.image = image;
        this.reviewDescription = reviewDescription;
        this.customer = customer;
        this.rating = rating;
        this.professional = professional;
        this.id = id;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Review getRating() {
        return rating;
    }

    public void setRating(Review rating) {
        this.rating = rating;
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

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
