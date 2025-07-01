package com.example.product.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.repo.CategoryRepo;
import com.example.product.repo.ProductRepo;

@Component
//@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {
    // spring mangage component so we going to have dummy data

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public DataSeeder(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }
    @Override
    public void run(String... args) throws Exception {
        // clear all existing data
        productRepo.deleteAll();
        categoryRepo.deleteAll();

        // create category
        Category electronic = new Category();
        electronic.setName("Food & Beverage");

        // create clothing
        Category clothes = new Category();
        clothes.setName("Clothing");

        // create Kittchen
        Category home = new Category();
        home.setName("Gifts");

        categoryRepo.saveAll(Arrays.asList(electronic, clothes, home));


        // create products
        Product sugar = new Product();
        sugar.setNamel("Smart Phone");
        sugar.setDescription("Latest model smartphone with amazing features");
        sugar.setImgUrl("img/claypot.png");
        sugar.setPrice(699.99);
        sugar.setCategory(electronic);


        // creating laptop
        Product laptop = new Product();
        laptop.setNamel("laptop");
        laptop.setDescription("High performance laptop for work and video game");
        laptop.setImgUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronic);

        // creating jakcet
        Product jacket = new Product();
        jacket.setNamel("jacket");
        jacket.setDescription("winter jacket with fashion style");
        jacket.setImgUrl("https://placehold.co/600x400");
        jacket.setPrice(129.99);
        jacket.setCategory(clothes);

        // creating blender
        Product blender = new Product();
        blender.setNamel("blender");
        blender.setDescription("High-speed blender for smoothies and more");
        blender.setImgUrl("https://placehold.co/600x400");
        blender.setPrice(79.99);
        blender.setCategory(clothes);


        productRepo.saveAll(Arrays.asList(sugar,laptop,jacket,blender));


    }

}
