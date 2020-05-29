package by.bsuir.lukashevich.shopdemo.service;

import by.bsuir.lukashevich.shopdemo.model.Stock;
import by.bsuir.lukashevich.shopdemo.repositary.StockRepositary;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepositary stockRepositary;

    @Autowired
    public StockService(StockRepositary stockRepositary) {
        this.stockRepositary = stockRepositary;
    }

    public Stock findById(Long id) {
        return stockRepositary.getOne(id);
    }

    public List<Stock> findAll() {
        return stockRepositary.findAll();
    }

    public Stock saveStock(Stock stock) {
        return stockRepositary.save(stock);
    }

    public void deleteById(Long id) {
        stockRepositary.deleteById(id);
    }
}
