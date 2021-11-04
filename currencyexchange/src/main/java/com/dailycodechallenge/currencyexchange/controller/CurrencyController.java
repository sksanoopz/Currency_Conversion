package com.dailycodechallenge.currencyexchange.controller;

import com.dailycodechallenge.currencyexchange.entity.CurrencyRate;
import com.dailycodechallenge.currencyexchange.service.ConvesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    ConvesionService convesionService;

    @PostMapping("/add")
    public CurrencyRate addCurrencyRate(@RequestBody CurrencyRate currencyRate)
    {
        return convesionService.addCurrencyRate(currencyRate);
    }

    @GetMapping("/get/{from}/to/{to}")
    public CurrencyRate getCurrencyRate(@PathVariable String from, @PathVariable String to)
    {
        return convesionService.getCurrencyRate(from,to);
    }
}
