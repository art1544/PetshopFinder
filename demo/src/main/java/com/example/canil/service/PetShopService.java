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

    /**
     * Método que encontra o melhor PetShop com base na data, quantidade de cães pequenos e quantidade de cães grandes.
     * 
     * @param data a data no formato "dd/MM/yyyy"
     * @param caesPequenos a quantidade de cães pequenos
     * @param caesGrandes a quantidade de cães grandes
     * @return uma string contendo o nome do melhor PetShop, o preço total e se é final de semana ou dia útil
     *         ou a mensagem "Nenhum petshop encontrado" caso nenhum PetShop seja encontrado
     */
    public String achaMelhorPetshop(String data, int caesPequenos, int caesGrandes) {
        LocalDate date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<PetShop> petShops = petShopRepository.findAll();
        PetShop melhorShop = null;
        double melhorPreco = Double.MAX_VALUE;

        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;

        for (PetShop shop : petShops) {
            double precoTotal = 0;
            for (Price preco : shop.getPrices()) {
                if (preco.isWeekend() == isWeekend) {
                    precoTotal += preco.getCaoPequenoPreco() * caesPequenos + preco.getCaoGrandePreco() * caesGrandes;
                }
            }

            if (precoTotal < melhorPreco || (precoTotal == melhorPreco && (melhorShop == null || shop.getDistance() < melhorShop.getDistance()))) {
                melhorShop = shop;
                melhorPreco = precoTotal;
            }
        }

        return melhorShop != null ?
                String.format("Melhor PetShop: %s, Preço Total: R$ %.2f, %s", melhorShop.getName(), melhorPreco, isWeekend ? "Final de Semana" : "Dia Útil") :
                "Nenhum petshop encontrado";
    }
}
