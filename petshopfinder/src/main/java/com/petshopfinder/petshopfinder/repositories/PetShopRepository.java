package com.petshopfinder.petshopfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopfinder.petshopfinder.models.Petshop;

public interface PetShopRepository extends JpaRepository<Petshop, Long> {
}