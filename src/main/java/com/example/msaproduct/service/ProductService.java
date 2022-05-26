package com.example.msaproduct.service;

import com.example.msaproduct.config.FeignClient;
import com.example.msaproduct.domain.Product;
import com.example.msaproduct.domain.ProductRepository;
import com.example.msaproduct.util.ResponseForm;
import com.example.msaproduct.util.ValidationCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final FeignClient feignClient;

    public ResponseForm productMaking(String name, Long price, Long amount){
        try {
            ValidationCustom.nameCheck(name);
            ValidationCustom.priceCheck(price);
            ValidationCustom.amountCheck(amount);

            Product product = Product.builder().name(name).price(price).amount(amount).build();
            productRepository.save(product);
        } catch (Exception e) {
            return ResponseForm.fail(0, e.getMessage());
        }
        return ResponseForm.success();
    }

    public ResponseForm productRemove(String name){
        try {
            Product product = productRepository.findByName(name);
            productRepository.delete(product);
        } catch (Exception e) {
            return ResponseForm.fail(0, e.getMessage());
        }
        return ResponseForm.success();
    }

    public ResponseForm productPriceChange(String name, Long price){
        try {
            Product product = productRepository.findByName(name);
            product.productUpdate(product.getName(), price, product.getAmount());
            productRepository.save(product);
        } catch (Exception e) {
            return ResponseForm.fail(0, e.getMessage());
        }
        return ResponseForm.success();
    }

    public ResponseForm productAmountChange(String name, Long amount){
        try {
            Product product = productRepository.findByName(name);
            product.productUpdate(product.getName(), product.getPrice(), amount);
            productRepository.save(product);
        } catch (Exception e){
            return ResponseForm.fail(0, e.getMessage());
        }
        return ResponseForm.success();
    }

    public ResponseForm productBuy(String name){
        try {
            Product product = productRepository.findByName(name);
            ValidationCustom.amountEnough(product.getAmount(), 1);
            product.productUpdate(name, product.getPrice(), product.getAmount()-1);
            productRepository.save(product);
        } catch (Exception e){
            return ResponseForm.fail(0, e.getMessage());
        }
        return ResponseForm.success();
    }

    public ResponseForm allProduct(){
        List<Product> products = null;
        try {
            products = productRepository.findAll();
        } catch (Exception e){
            ResponseForm.fail(0, e.getMessage());
        }
        return ResponseForm.successWithList(products);
    }

    /**
     * test
     */

    public String feignTest(){
        return feignClient.feignTest();
    }

}
