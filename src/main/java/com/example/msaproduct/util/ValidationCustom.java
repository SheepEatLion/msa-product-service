package com.example.msaproduct.util;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.hibernate.service.spi.ServiceException;
import org.springframework.context.annotation.Bean;

import java.util.regex.Pattern;

public class ValidationCustom {

    public static void nameCheck(String name){
        String regex = "[가-힣a-zA-Z]+$";
        if(!Pattern.matches(regex, name)){
            throw new ServiceException("영문과 한글만 입력가능합니다.");
        }
    }

    public static void priceCheck(Long price){
        if(price < 0){
            throw new ServiceException("가격은 음수일 수 없습니다.");
        }
    }

    public static void amountCheck(Long amount){
        if(amount < 0){
            throw new ServiceException("재고는 음수일 수 없습니다.");
        }
    }

    public static void amountEnough(Long amount, int input){
        if(amount < input){
            throw new ServiceException("재고가 부족합니다.");
        }
    }
}
