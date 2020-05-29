package by.bsuir.lukashevich.shopdemo.controller;

import by.bsuir.lukashevich.shopdemo.model.Stock;
import by.bsuir.lukashevich.shopdemo.service.StockService;
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
public class StockController {
    Logger logger = LoggerFactory.getLogger(StockController.class);
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public String findAll(Model model) {
        List<Stock> stocks = stockService.findAll();
        model.addAttribute("stocks", stocks);
        return "stock-list";
    }

    @GetMapping("/stock-create")
    public String createStockForm(Stock stock) {
        return "stock-create";
    }

    @PostMapping("/stock-create")
    public String createStock(Stock stock) {
        stockService.saveStock(stock);
        logger.info("Stock has been created: " + stock.toString());
        return "redirect:/stocks";
    }

    @GetMapping("/stock-delete/{id}")
    public String deleteStock(@PathVariable("id") Long id) {
        stockService.deleteById(id);
        logger.info("Stock has been deleted. Id: " + id);
        return "redirect:/stocks";
    }

    @GetMapping("/stock-update/{id}")
    public String updateStockForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("stock", stockService.findById(id));
        return "stock-update";
    }

    @PostMapping("/stock-update")
    public String updateStock(Stock stock) {
        stockService.saveStock(stock);
        logger.info("Stock has been updated: " + stock.toString());
        return "redirect:/stocks";
    }
}
