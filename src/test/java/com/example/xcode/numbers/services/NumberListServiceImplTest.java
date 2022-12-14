package com.example.xcode.numbers.services;

import com.example.xcode.numbers.commons.SortingOrder;
import com.example.xcode.numbers.dto.NumberListDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NumberListServiceImplTest {

    @Autowired
    private NumberListService numberListService;
    private final List<Integer> exampleList = List.of(1, 5, 25, 35, 0, 1, 45);

    @Test
    void sort_ASC() {
        NumberListDto givenNumberList = new NumberListDto(exampleList, SortingOrder.ASC);

        List<Integer> result = numberListService.sort(givenNumberList);

        Assertions.assertArrayEquals(List.of(0,1,1,5,25,35,45).toArray(), result.toArray());
    }

    @Test
    void sort_DESC() {
        NumberListDto givenNumberList = new NumberListDto(exampleList, SortingOrder.DESC);

        List<Integer> result = numberListService.sort(givenNumberList);

        Assertions.assertArrayEquals(List.of(45,35,25,5,1,1,0).toArray(), result.toArray());
    }

}