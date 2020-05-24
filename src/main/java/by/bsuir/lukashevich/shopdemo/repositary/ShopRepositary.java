package by.bsuir.lukashevich.shopdemo.repositary;

import by.bsuir.lukashevich.shopdemo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepositary extends JpaRepository<Shop, Long> {
}
