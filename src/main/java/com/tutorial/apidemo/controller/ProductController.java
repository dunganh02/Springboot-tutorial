package com.tutorial.apidemo.controller;

import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {


    //DI: Dependency Injection
    @Autowired
    private ProductRepository repository; // khi có chứa @Autowired thì đối tượng ProductRepository sẽ được tạo ra ngay khi app được tạo. Tạo ra một lần

    @GetMapping("")
    // http://localhost:8080/api/v1/Products
    List<Product> getAllProduct() {
        return repository.findAll();
    }
}
