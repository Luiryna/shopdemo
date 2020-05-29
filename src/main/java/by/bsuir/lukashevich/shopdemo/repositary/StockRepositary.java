package by.bsuir.lukashevich.shopdemo.repositary;

import by.bsuir.lukashevich.shopdemo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepositary extends JpaRepository<Stock, Long> {
}
