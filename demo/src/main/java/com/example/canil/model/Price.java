package com.example.canil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Entity representation for a Price related to the services offered by a PetShop.
 */
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isWeekend;
    private double smallDogPrice;
    private double largeDogPrice;

    @ManyToOne
    @JoinColumn(name = "petshop_id", nullable = false)
    private PetShop petShop;

    public Price() {
        // Default constructor for JPA
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getSmallDogPrice() {
        return smallDogPrice;
    }

    public void setSmallDogPrice(double smallDogPrice) {
        this.smallDogPrice = smallDogPrice;
    }

    public double getLargeDogPrice() {
        return largeDogPrice;
    }

    public void setLargeDogPrice(double largeDogPrice) {
        this.largeDogPrice = largeDogPrice;
    }

    public PetShop getPetShop() {
        return petShop;
    }

    public void setPetShop(PetShop petShop) {
        this.petShop = petShop;
    }
}
