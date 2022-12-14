package com.example.xcode.numbers.services;

import com.example.xcode.numbers.dto.NumberListDto;

import java.util.List;

public interface NumberListService {

    List<Integer> sort(NumberListDto numberList);

}
