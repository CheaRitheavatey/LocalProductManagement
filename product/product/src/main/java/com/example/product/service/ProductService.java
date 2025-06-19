package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    // data field
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public List<Product> getProductByCategory(Long id) {
        return productRepo.findByCategoryId(id);
    }

}
