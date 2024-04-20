package com.example.canil.service;

import com.example.canil.model.PetShop;
import com.example.canil.model.Price;
import com.example.canil.repository.PetShopRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class PetShopService {

    private final PetShopRepository petShopRepository;

    public PetShopService(PetShopRepository petShopRepository) {
        this.petShopRepository = petShopRepository;
    }

    public String findBestPetShop(Calendar date, int smallDogs, int largeDogs) {
        List<PetShop> petShops = petShopRepository.findAll();
        PetShop bestShop = null;
        double bestPrice = Double.MAX_VALUE;

        // Determinar se é final de semana
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        boolean isWeekend = (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);

        for (PetShop shop : petShops) {
            double totalPrice = 0;
            for (Price price : shop.getPrices()) {
                if (price.isWeekend() == isWeekend) {
                    double costForSmallDogs = price.getSmallDogPrice() * smallDogs;
                    double costForLargeDogs = price.getLargeDogPrice() * largeDogs;
                    totalPrice += costForSmallDogs + costForLargeDogs;
                }
            }

            // Se encontrarmos um preço melhor ou se o preço for o mesmo mas a loja for mais próxima
            if (totalPrice < bestPrice || (totalPrice == bestPrice && (bestShop == null || shop.getDistance() < bestShop.getDistance()))) {
                bestShop = shop;
                bestPrice = totalPrice;
            }
        }

        return bestShop != null ?
                String.format("Melhor PetShop: %s, Preço Total: R$ %.2f, Dia da Semana: %s", bestShop.getName(), bestPrice, isWeekend ? "Final de Semana" : "Dia Útil") :
                "Nenhum petshop encontrado";
    }
}
