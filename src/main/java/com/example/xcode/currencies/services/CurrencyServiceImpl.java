package com.example.xcode.currencies.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private static final String NBP_SINGLE_CURRENCY_URL = "http://api.nbp.pl/api/exchangerates/rates/A/";
    private static final String NBP_JSON_FORMAT = "?format=json";


    public BigDecimal getCurrencyValue(String currencyCode) {
        String uri = NBP_SINGLE_CURRENCY_URL + currencyCode + NBP_JSON_FORMAT;
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonResponse = restTemplate.getForObject(uri, JsonNode.class);
        return  jsonResponse.get("rates").get(0).get("mid").decimalValue();
    }

}
