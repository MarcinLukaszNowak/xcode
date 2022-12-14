package com.example.xcode.currencies.services;

import java.math.BigDecimal;

public interface CurrencyService {

    BigDecimal getCurrencyValue(String currencyCode);

}
