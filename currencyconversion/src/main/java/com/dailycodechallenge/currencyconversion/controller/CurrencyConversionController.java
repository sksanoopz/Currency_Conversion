package com.dailycodechallenge.currencyconversion.controller;

import com.dailycodechallenge.currencyconversion.entity.CurrencyResponse;
import com.dailycodechallenge.currencyconversion.entity.ExchangeResponse;
import com.dailycodechallenge.currencyconversion.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/convert")
public class CurrencyConversionController {

    @Autowired
    CurrencyConversionService currencyConversionService;

    @GetMapping("/{from}/to/{to}/{amount}")
    public CurrencyResponse getCurrencyResponse(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal amount)
    {
        return currencyConversionService.getCurrencyRespose(from,to,amount);
    }
}
