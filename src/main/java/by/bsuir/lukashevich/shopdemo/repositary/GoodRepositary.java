package by.bsuir.lukashevich.shopdemo.repositary;

import by.bsuir.lukashevich.shopdemo.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepositary extends JpaRepository<Good, Long> {
}
