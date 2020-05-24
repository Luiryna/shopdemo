package by.bsuir.lukashevich.shopdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "post")
    private String post;
    @Column(name = "number")
    private String number;
}
