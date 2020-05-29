package by.bsuir.lukashevich.shopdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "goods_in_stock")
public class GoodsInStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_id")
    private int stockId;
    @Column(name = "good_id")
    private int goodId;
    @Column(name = "price")
    private int price;
    @Column(name = "value")
    private int value;
}
