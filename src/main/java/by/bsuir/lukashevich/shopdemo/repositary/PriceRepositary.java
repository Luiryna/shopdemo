package by.bsuir.lukashevich.shopdemo.repositary;

import by.bsuir.lukashevich.shopdemo.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepositary extends JpaRepository<Price, Long> {
}
