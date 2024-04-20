package com.example.canil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
    }

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

    public double getCaoPequenoPreco() {
        return smallDogPrice;
    }

    public void setSmallDogPrice(double smallDogPrice) {
        this.smallDogPrice = smallDogPrice;
    }

    public double getCaoGrandePreco() {
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

    public void setCaoPequenoPreco(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCaoPequenoPreco'");
    }

    public void setCaoGrandePreco(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCaoGrandePreco'");
    }
}
