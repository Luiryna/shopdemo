package by.bsuir.lukashevich.shopdemo.repositary;

import by.bsuir.lukashevich.shopdemo.model.GoodsInStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsInStockRepositary extends JpaRepository<GoodsInStock, Long> {
}
