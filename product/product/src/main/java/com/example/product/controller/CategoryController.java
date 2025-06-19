package com.example.product.controller;

import com.example.product.model.Category;
import com.example.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/categories")
@CrossOrigin(origins = "http://localhost:5173/")
public class CategoryController {
    private final CategoryService categoryService;

    // method
    @Autowired
    public CategoryController(CategoryService categoryService) {this.categoryService = categoryService;}

    @GetMapping()
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }
}
