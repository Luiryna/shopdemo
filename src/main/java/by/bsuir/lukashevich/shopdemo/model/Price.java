package by.bsuir.lukashevich.shopdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "shop_id")
    private int shopId;
    @Column(name = "value")
    private String value;
}
