package by.bsuir.lukashevich.shopdemo.controller;

import by.bsuir.lukashevich.shopdemo.model.Good;
import by.bsuir.lukashevich.shopdemo.service.GoodService;
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
public class GoodController {
    Logger logger = LoggerFactory.getLogger(GoodController.class);
    private final GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @GetMapping("/goods")
    public String findAll(Model model){
        List<Good>  goods = goodService.findAll();
        model.addAttribute("goods", goods);
        return "good-list";
    }

    @GetMapping("/good-create")
    public String createGoodForm(Good good){
        return "good-create";
    }

    @PostMapping("/good-create")
    public String createGood(Good good){
        goodService.saveGood(good);
        logger.info("Good has been created: " + good.toString());
        return "redirect:/goods";
    }

    @GetMapping("/good-delete/{id}")
    public String deleteGood(@PathVariable("id") Long id){
        goodService.deleteById(id);
        logger.info("Good has been deleted. Id: " + id);
        return "redirect:/goods";
    }

    @GetMapping("/good-update/{id}")
    public String updateGoodForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("good", goodService.findById(id));
        return "good-update";
    }

    @PostMapping("/good-update")
    public String updateGood(Good good){
        goodService.saveGood(good);
        logger.info("Good has been updated: " + good.toString());
        return "redirect:/goods";
    }

}
