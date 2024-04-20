package com.example.canil.service;

import com.example.canil.model.PetShop;
import com.example.canil.model.Price;
import com.example.canil.repository.PetShopRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.util.List;

@Service
public class PetShopService {

    private final PetShopRepository petShopRepository;

    public PetShopService(PetShopRepository petShopRepository) {
        this.petShopRepository = petShopRepository;
    }

    public String findBestPetShop(String dateStr, int smallDogs, int largeDogs) {
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<PetShop> petShops = petShopRepository.findAll();
        PetShop bestShop = null;
        double bestPrice = Double.MAX_VALUE;

        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;

        for (PetShop shop : petShops) {
            double totalPrice = 0;
            for (Price price : shop.getPrices()) {
                if (price.isWeekend() == isWeekend) {
                    totalPrice += price.getSmallDogPrice() * smallDogs + price.getLargeDogPrice() * largeDogs;
                }
            }

            if (totalPrice < bestPrice || (totalPrice == bestPrice && (bestShop == null || shop.getDistance() < bestShop.getDistance()))) {
                bestShop = shop;
                bestPrice = totalPrice;
            }
        }

        return bestShop != null ?
                String.format("Melhor PetShop: %s, Preço Total: R$ %.2f, %s", bestShop.getName(), bestPrice, isWeekend ? "Final de Semana" : "Dia Útil") :
                "Nenhum petshop encontrado";
    }
}
