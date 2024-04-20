package com.example.canil.controller;

import com.example.canil.service.PetShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetShopController {
    private final PetShopService petShopService;

    public PetShopController(PetShopService petShopService) {
        this.petShopService = petShopService;
    }

    @GetMapping("/")
    public String getBestOption(@RequestParam(required = false) String date,
                                @RequestParam(required = false) Integer smallDogs,
                                @RequestParam(required = false) Integer largeDogs,
                                Model model) {
        if (date != null && smallDogs != null && largeDogs != null) {
            String result = petShopService.findBestPetShop(date, smallDogs, largeDogs);
            model.addAttribute("result", result);
        }
        return "index";
    }
}
