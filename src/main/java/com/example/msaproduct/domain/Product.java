package com.example.msaproduct.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 상품 엔티티
 * 컬럼 -> 상품명, 가격, 재고량
 */

@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long amount;

    /*
     * 이하 비지니스 로직
     */

    @Builder
    public Product(String name, Long price, Long amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Product productUpdate(String name, Long price, Long amount){

        this.name = name;
        this.price = price;
        this.amount = amount;

        return this;
    }
}
