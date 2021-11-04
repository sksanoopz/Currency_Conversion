package com.dailycodechallenge.currencyexchange.repository;

import com.dailycodechallenge.currencyexchange.controller.CurrencyController;
import com.dailycodechallenge.currencyexchange.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRepository extends JpaRepository<CurrencyRate,Long> {

    public CurrencyRate findByFromCurrencyAndToCurrency(String from,String to);
}
