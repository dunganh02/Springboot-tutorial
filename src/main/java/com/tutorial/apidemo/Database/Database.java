package com.tutorial.apidemo.Database;

import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {

    // logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() { // CommandLineRunner: là một interface
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("MacBook Pro 16", 2020, 123.6, "");
                Product productB = new Product("Dell 3345", 20219, 343.6, "");
                logger.info("Insert data: " + productRepository.save(productA));
                logger.info("Insert data: " + productRepository.save(productB)); // save nhấn bản nghi vào database
            }
        };

    }


}
