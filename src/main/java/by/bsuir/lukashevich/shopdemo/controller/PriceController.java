package by.bsuir.lukashevich.shopdemo.controller;

import by.bsuir.lukashevich.shopdemo.model.Good;
import by.bsuir.lukashevich.shopdemo.model.Price;
import by.bsuir.lukashevich.shopdemo.service.GoodService;
import by.bsuir.lukashevich.shopdemo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PriceController {
    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/prices")
    public String findAll(Model model){
        List<Price>  prices = priceService.findAll();
        model.addAttribute("prices", prices);
        return "price-list";
    }

    @GetMapping("/price-create")
    public String createPriceForm(Price price){
        return "price-create";
    }

    @PostMapping("/price-create")
    public String createPrice(Price price){
        priceService.savePrice(price);
        return "redirect:/prices";
    }

    @GetMapping("/price-delete/{id}")
    public String deletePrice(@PathVariable("id") Long id){
        priceService.deleteById(id);
        return "redirect:/prices";
    }

    @GetMapping("/price-update/{id}")
    public String updatePriceForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("price", priceService.findById(id));
        return "price-update";
    }

    @PostMapping("/price-update")
    public String updatePrice(Price price){
        priceService.savePrice(price);
        return "redirect:/prices";
    }

}