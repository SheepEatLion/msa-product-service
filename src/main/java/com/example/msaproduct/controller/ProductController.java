package com.example.msaproduct.controller;

import com.example.msaproduct.service.ProductService;
import com.example.msaproduct.dto.ProductCreateForm;
import com.example.msaproduct.util.ResponseForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseForm productMaking(@RequestBody ProductCreateForm productCreateForm){
        log.info("product save: {}, {}, {}", productCreateForm.getName(), productCreateForm.getPrice(), productCreateForm.getAmount());
        return productService.productMaking(productCreateForm.getName(), productCreateForm.getPrice(), productCreateForm.getAmount());
    }

    @GetMapping("/products")
    public ResponseForm allProduct(){
        return productService.allProduct();
    }

    @DeleteMapping("/remove")
    public ResponseForm productRemove(@RequestParam("name") String name){
        log.info("product delete: {}", name);
        return productService.productRemove(name);
    }

    @PutMapping("/price")
    public ResponseForm priceChange(@RequestParam("name") String name, @RequestBody Long price){
        log.info("product price change: {}, {}", name, price);
        return productService.productPriceChange(name, price);
    }

    @PutMapping("/amount")
    public ResponseForm amountChange(@RequestParam("name") String name, @RequestBody Long amount){
        log.info("product price change: {}, {}", name, amount);
        return productService.productAmountChange(name, amount);
    }

    @GetMapping("/buy")
    public ResponseForm productBuy(@RequestParam("name") String name){
        log.info("product buy: {}", name);
        return productService.productBuy(name);
    }
}
