package com.example.msaproduct.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductCreateForm {
    private String name;
    private Long price;
    private Long amount;
}
