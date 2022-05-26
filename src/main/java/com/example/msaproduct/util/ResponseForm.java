package com.example.msaproduct.util;

import com.example.msaproduct.domain.Product;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
public class ResponseForm <T> {

    private Integer code;
    private String msg;
    private T data;

    public static ResponseForm success(){
        return ResponseForm.builder().code(200).msg("success").data(null).build();
    }

    public static ResponseForm fail(Integer code, String msg){
        return ResponseForm.builder().code(code).msg(msg).data(null).build();
    }

    public static ResponseForm successWithList(List<Product> data){
        return ResponseForm.builder().code(200).msg("success").data(data).build();
    }

    public static ResponseForm successWithSingle(Product data){
        return ResponseForm.builder().code(200).msg("success").data(data).build();
    }
}
