package com.example.product.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    // data field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namel;
    private String description;
    private String imgUrl;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}
