package com.example.xcode.numbers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "The list cannot be empty or null.")
public class EmptyListException extends RuntimeException {
}
