package com.example.query.repository;

import com.example.query.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> products;
    public List<Product> findAll() {
        return products;
    }
    public Product save(Product product) {
        if (product.getId() == null)
            return insert(product);
        Optional<Product> first = findById(product.getId());
        return first.map(value-> update(value, product)).orElse(null);
    }

    public Optional<Product> findById(Long id) {
        Optional<Product> first = products.stream()
                .filter(pr -> pr.getId().equals(id))
                .findFirst();
        return first;
    }

    private Product update(Product product, Product before) {

        Product build = Product.builder()
                .id(product.getId())
                .price(getPrice(before, product))
                .name(product.getName())
                .quantity(product.getQuantity())
                .build();
        products.set(products.indexOf(product), build);

        return build;

    }

    private Product insert(Product product) {
        Product build = Product.builder()
                .id(products.size() + 1L)
                .price(product.getPrice())
                .name(product.getName())
                .quantity(product.getQuantity() == null ? 0: product.getQuantity())
                .build();
        products.add(build);
        return build;
    }

    private static Long getPrice(Product product, Product product1) {
        return product1.getPrice() != null ? product.getPrice() : product1.getPrice();
    }

    public ProductRepository() {
        this.products = new ArrayList<>();
        Product test = Product.builder()
                .id(products.size()+1l)
                .price(10000L)
                .name("test")
                .quantity(0L)
                .build();
        products.add(test);
    }
}
