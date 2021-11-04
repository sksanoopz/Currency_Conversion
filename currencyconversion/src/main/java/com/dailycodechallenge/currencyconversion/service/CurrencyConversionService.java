package com.dailycodechallenge.currencyconversion.service;

import com.dailycodechallenge.currencyconversion.entity.CurrencyResponse;
import com.dailycodechallenge.currencyconversion.entity.ExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyConversionService {

    @Autowired
    RestTemplate restTemplate;

    public CurrencyResponse getCurrencyRespose(String from, String to, BigDecimal amount)
    {
        Map<String, String> parameters=new HashMap<>();
        parameters.put("from", from);
        parameters.put("to", to);

        ResponseEntity<ExchangeResponse> exchangeResponseResponseEntity =
                restTemplate.getForEntity("http://localhost:8085/currency/get/{from}/to/{to}",ExchangeResponse.class,parameters);
        //return exchangeResponseResponseEntity;
        CurrencyResponse currencyResponse = new CurrencyResponse();
        currencyResponse.setFromCurrency(exchangeResponseResponseEntity.getBody().getFromCurrency());
        currencyResponse.setToCurrency(exchangeResponseResponseEntity.getBody().getToCurrency());
        currencyResponse.setConversionRate(exchangeResponseResponseEntity.getBody().getConversionRate());
        currencyResponse.setConvertedAmount(exchangeResponseResponseEntity.getBody().getConversionRate().multiply(amount));
        return currencyResponse;
    }
}
