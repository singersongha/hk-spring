package com.example.jpatest.order.domain;

import com.example.jpatest.store.domain.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS", indexes = {@Index(columnList = "productName")})
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;
}
