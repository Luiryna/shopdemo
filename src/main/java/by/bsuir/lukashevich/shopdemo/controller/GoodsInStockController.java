package by.bsuir.lukashevich.shopdemo.controller;

import by.bsuir.lukashevich.shopdemo.model.GoodsInStock;
import by.bsuir.lukashevich.shopdemo.service.GoodsInStockService;
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
public class GoodsInStockController {
    Logger logger = LoggerFactory.getLogger(ShopController.class);
    private final GoodsInStockService goodsInStockService;

    @Autowired
    public GoodsInStockController(GoodsInStockService goodsInStockService) {
        this.goodsInStockService = goodsInStockService;
    }

    @GetMapping("/goodsinstocks")
    public String findAll(Model model) {
        List<GoodsInStock> goodsInStocks = goodsInStockService.findAll();
        model.addAttribute("goodsinstocks", goodsInStocks);
        return "goodsinstock-list";
    }

    @GetMapping("/goodsinstock-create")
    public String createGoodsInStockForm(GoodsInStock goodsInStock) {
        return "goodsinstock-create";
    }

    @PostMapping("/goodsinstock-create")
    public String createGoodsInStock(GoodsInStock goodsInStock) {
        goodsInStockService.saveGoodsInStock(goodsInStock);
        logger.info("Shop has been created: " + goodsInStock.toString());
        return "redirect:/goodsinstocks";
    }

    @GetMapping("/goodsinstock-delete/{id}")
    public String deleteGoodsInStock(@PathVariable("id") Long id) {
        goodsInStockService.deleteById(id);
        logger.info("Shop has been deleted. Id: " + id);
        return "redirect:/goodsinstocks";
    }

    @GetMapping("/goodsinstock-update/{id}")
    public String updateGoodsInStockForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("goodsinstock", goodsInStockService.findById(id));
        return "goodsinstock-update";
    }

    @PostMapping("/goodsinstock-update")
    public String updateGoodsInStock(GoodsInStock goodsInStock) {
        goodsInStockService.saveGoodsInStock(goodsInStock);
        logger.info("Goods in stock has been updated: " + goodsInStock.toString());
        return "redirect:/goodsinstocks";
    }

}
