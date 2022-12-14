package com.example.xcode.currencies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Currency not found.")
public class CurrencyNotFoundException extends RuntimeException {
}
