package by.bsuir.lukashevich.shopdemo.service;

import by.bsuir.lukashevich.shopdemo.model.Good;
import by.bsuir.lukashevich.shopdemo.repositary.GoodRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    private final GoodRepositary goodRepositary;

    @Autowired
    public GoodService(GoodRepositary goodRepositary){
        this.goodRepositary = goodRepositary;
    }

    public Good findById(Long id) {
        return goodRepositary.getOne(id);
    }

    public List<Good> findAll() {
        return goodRepositary.findAll();
    }

    public Good saveGood(Good good) {
        return goodRepositary.save(good);
    }

    public void deleteById(Long id) {
        goodRepositary.deleteById(id);
    }
}
