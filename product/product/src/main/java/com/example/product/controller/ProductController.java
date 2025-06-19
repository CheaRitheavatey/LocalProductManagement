package com.example.product.controller;


import com.example.product.model.Product;
import com.example.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
public class ProductController {
    // data field
    private ProductService productService;

//    public ProductController(ProductService productService) {this.productService = productService;}

    @GetMapping()
    public List<Product> getAllProduct() {return productService.getAllProduct();}

    @GetMapping(path = "category/{categoryId}")
    public List<Product> getAllProductByCategory(@PathVariable Long categoryId ) {return productService.getProductByCategory(categoryId);}


}
