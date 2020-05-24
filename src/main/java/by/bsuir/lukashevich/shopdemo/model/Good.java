package by.bsuir.lukashevich.shopdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "shop_id")
    private int shopId;
    @Column(name = "quantity")
    private int quantity;
}
