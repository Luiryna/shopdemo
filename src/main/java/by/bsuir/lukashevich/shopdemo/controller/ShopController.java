package by.bsuir.lukashevich.shopdemo.controller;

import by.bsuir.lukashevich.shopdemo.model.Shop;
import by.bsuir.lukashevich.shopdemo.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShopController {
    Logger logger = LoggerFactory.getLogger(ShopController.class);
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shops")
    public String findAll(Model model) {
        List<Shop> shops = shopService.findAll();
        model.addAttribute("shops", shops);
        return "shop-list";
    }

    @GetMapping("/shop-create")
    public String createShopForm(Shop shop) {
        return "shop-create";
    }

    @PostMapping("/shop-create")
    public String createShop(Shop shop) {
        shopService.saveShop(shop);
        logger.info("Shop has been created: " + shop.toString());
        return "redirect:/shops";
    }

    @GetMapping("/shop-delete/{id}")
    public String deleteShop(@PathVariable("id") Long id) {
        shopService.deleteById(id);
        logger.info("Shop has been deleted. Id: " + id);
        return "redirect:/shops";
    }

    @GetMapping("/shop-update/{id}")
    public String updateShopForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("shop", shopService.findById(id));
        return "shop-update";
    }

    @PostMapping("/shop-update")
    public String updateShop(Shop shop) {
        shopService.saveShop(shop);
        logger.info("Shop has been updated: " + shop.toString());
        return "redirect:/shops";
    }

}
