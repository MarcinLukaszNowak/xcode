package com.example.xcode.currencies.controllers;

import com.example.xcode.currencies.dto.CurrencyDto;
import com.example.xcode.currencies.exceptions.CurrencyNotFoundException;
import com.example.xcode.currencies.services.CurrencyService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

@RestController
@RequestMapping("currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping(value = "get-current-currency-value-command")
    public ResponseEntity getCurrencyValue(@RequestBody CurrencyDto currencyDto) {
        try {
            BigDecimal value = currencyService.getCurrencyValue(currencyDto.getCurrency());
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("value", value);
            return ResponseEntity.ok(jsonObject.toString());
        } catch (HttpClientErrorException e) {
            if (HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
                throw new CurrencyNotFoundException();
            } else {
                throw e;
            }
        }
    }

}
