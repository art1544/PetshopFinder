package com.petshopfinder.petshopfinder.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.petshopfinder.petshopfinder.services.PetShopService;

@Controller
public class PetShopController {

    @Autowired
    private PetShopService petShopService;

    @GetMapping("/petshop")
    public String encontrarMelhorPetShop(@RequestParam String data,
                                         @RequestParam int quantidadePequenos,
                                         @RequestParam int quantidadeGrandes,
                                         Model model) {
        String melhorPetShop = petShopService.encontrarMelhorPetShop(data, quantidadePequenos, quantidadeGrandes);
        model.addAttribute("melhorPetShop", melhorPetShop);
        return "resultado";
    }
}
