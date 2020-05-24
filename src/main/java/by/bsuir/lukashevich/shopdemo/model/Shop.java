package by.bsuir.lukashevich.shopdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
}
