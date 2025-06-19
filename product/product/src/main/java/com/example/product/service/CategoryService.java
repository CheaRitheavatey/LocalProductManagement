package com.example.product.service;

import com.example.product.model.Category;
import com.example.product.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    // data field
    private final CategoryRepo categoryRepo;

    // constructor
    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }
}
