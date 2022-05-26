package com.example.msaproduct.config;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * eureka 설정과 같이 쓰여서 url 필요없음 X
 */
@org.springframework.cloud.openfeign.FeignClient(name = "product-service")
public interface FeignClient {

    @GetMapping("/feign-test")
    String feignTest();
}
