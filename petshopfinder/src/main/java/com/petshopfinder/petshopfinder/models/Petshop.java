package com.petshopfinder.petshopfinder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Petshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double distancia;
    private double precoPequenoSemana;
    private double precoGrandeSemana;
    private double precoPequenoFimSemana;
    private double precoGrandeFimSemana;

    // getters e setters
}