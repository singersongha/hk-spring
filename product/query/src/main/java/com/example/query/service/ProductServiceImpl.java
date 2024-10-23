package com.example.query.service;

import com.example.query.entity.Product;
import com.example.query.repository.ProductRepository;
import com.example.query.kafka.KafkaProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl  implements KafkaProductService {
    private final ProductRepository repository;

    @Override
    public void sell(Long productId) {
        Optional<Product> byId = repository.findById(productId);
        if(byId.isEmpty()) return;
        Product product = byId.get();
        product.setQuantity(product.getQuantity() - 1);
        repository.save(product);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void receive(Long productId) {
        Optional<Product> byId = repository.findById(productId);
        if(byId.isEmpty()) return;
        Product product = byId.get();
        product.setQuantity(product.getQuantity() + 1);
        repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

}
