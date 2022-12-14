package com.example.xcode.numbers.dto;

import com.example.xcode.numbers.commons.SortingOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class NumberListDto {

    private List<Integer> numbers;
    private SortingOrder order;

}
