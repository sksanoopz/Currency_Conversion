package com.dailycodechallenge.currencyexchange.service;

import com.dailycodechallenge.currencyexchange.entity.CurrencyRate;
import com.dailycodechallenge.currencyexchange.repository.ConversionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvesionService
{

    Logger logger = LoggerFactory.getLogger(ConvesionService.class);
    @Autowired
    ConversionRepository conversionRepository;

    public CurrencyRate addCurrencyRate(CurrencyRate currencyRate)
    {
        return conversionRepository.save(currencyRate);
    }

    public CurrencyRate getCurrencyRate(String from, String to)
    {
        logger.info(String.format("To %s From %s",to,from));
        return conversionRepository.findByFromCurrencyAndToCurrency(from,to);
    }
}
