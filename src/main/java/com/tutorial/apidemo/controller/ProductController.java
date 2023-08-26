package com.tutorial.apidemo.controller;

import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.models.ResponseObect;
import com.tutorial.apidemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    ResponseEntity<ResponseObect> findById(@PathVariable Long id) { //Optional:
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObect("Ok", "Query product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObect("False", "Cannot product with id = " + id, "")
                );
        // Những đoạn code có 1 if-else thì nên chuyển sang danhug này

 /*
        if (foundProduct.isPresent()) { // nếu tìm thấy data
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObect("Ok", "Query poduct successfully", foundProduct)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObect("False", "Cannot product with id " + id, "")
            );
        }

        */
    }

}
